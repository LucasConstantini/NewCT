package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.Administrador;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Financeiro;
import cleartrip.model.pojo.Solicitante;
import cleartrip.model.pojo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UsuarioDAO implements BaseDAO<Usuario> {

    public static final String TIPO_SOLICITANTE = "Solicitante";
    public static final String TIPO_FINANCEIRO = "Financeiro";
    public static final String TIPO_ADMINISTRADOR = "Administrador";

    public static final String CRITERION_TIPO_EQ = "1";
    public static final String CRITERION_NOME_I_LIKE = "2";
    public static final String CRITERION_USUARIO_EQ = "3";
    public static final String CRITERION_SENHA_EQ = "4";
    public static final String CRITERION_USUARIO_DESPESAS = "5";

    public Map<String, Double> ListGastos(Long id, Connection conn) throws Exception {
        String sql = "select cd.nome,sum(d.valor) from "
                + "(select id, nome from usuario where id=?) u "
                + "left join viagem v on u.id=v.usuario_fk "
                + "left join despesa d on v.id=d.viagem_fk "
                + "left join categoria_despesa cd on cd.id=d.categoria_despesa_fk "
                + "group by u.nome,cd.nome";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Map<String, Double> results = new LinkedHashMap<>();
        while (rs.next()) {
            results.put(rs.getString("nome"), rs.getDouble("sum"));
        }
        rs.close();
        ps.close();
        return results;
    }

    @Override
    public void create(Usuario e, Connection conn) throws Exception {
        String sql = "INSERT INTO usuario (tipo, login, senha, nome, cpf, rg, emailcorporativo, telefonecorporativo, emailpessoal, telefonepessoal, empresa_fk) VALUES(?,?,?,?,?,?,?,?,?,?,?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getTipo());
        ps.setString(++i, e.getLogin());
        ps.setString(++i, e.getSenha());
        ps.setString(++i, e.getNome());
        ps.setLong(++i, e.getCpf());
        ps.setString(++i, e.getRg());
        ps.setString(++i, e.getEmailCorporativo());
        ps.setString(++i, e.getTelefoneCorporativo());
        //para campos não obrigatórios 
        if (e.getEmailPessoal() != null) {
            ps.setString(++i, e.getEmailPessoal());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getTelefonePessoal() != null) {
            ps.setString(++i, e.getTelefonePessoal());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        ps.setLong(++i, e.getEmpresa().getId());

        ps.execute();
        ps.close();

    }

    @Override
    public Usuario readById(Long id, Connection conn) throws Exception {
        Usuario e = null;
        String sql = "SELECT usuario.*, empresa.id as empresa_id, empresa.nome as empresa_nome FROM empresa right join usuario on usuario.empresa_fk = empresa.id where usuario.id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            String tipo = rs.getString("tipo");
            if (tipo.equalsIgnoreCase(TIPO_ADMINISTRADOR)) {
                e = new Administrador();
            } else if (tipo.equalsIgnoreCase(TIPO_FINANCEIRO)) {
                e = new Financeiro();
            } else {
                e = new Solicitante();
            }
            e.setId(rs.getLong("id"));
            e.setTipo(rs.getString("tipo"));
            e.setLogin(rs.getString("login"));
            e.setSenha(rs.getString("senha"));
            e.setNome(rs.getString("nome"));
            e.setCpf(rs.getLong("cpf"));
            e.setRg(rs.getString("rg"));
            e.setEmailCorporativo(rs.getString("emailcorporativo"));
            e.setEmailPessoal(rs.getString("emailpessoal"));
            e.setTelefoneCorporativo(rs.getString("telefonecorporativo"));
            e.setTelefonePessoal(rs.getString("telefonepessoal"));

            //empresa
            Empresa empresa = new Empresa();
            empresa.setId(rs.getLong("empresa_id"));
            empresa.setNome(rs.getString("empresa_nome"));
            e.setEmpresa(empresa);

        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<Usuario> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Usuario> lista = new ArrayList<Usuario>();
        String sql = "SELECT usuario.id, usuario.tipo,usuario.login,usuario.senha,usuario.nome,usuario.cpf,usuario.rg,usuario.emailcorporativo,usuario.emailpessoal,usuario.telefonecorporativo,usuario.telefonepessoal, empresa.id as empresa_id, empresa.nome as empresa_nome FROM empresa right join usuario on usuario.empresa_fk = empresa.id WHERE 1=1";

        String criterionTipoEq = (String) criteria.get(CRITERION_TIPO_EQ);
        if (criterionTipoEq != null && !criterionTipoEq.trim().isEmpty()) {
            sql += " AND usuario.tipo = '" + criterionTipoEq + "'";
        }

        String criterionUsuarioEq = (String) criteria.get(CRITERION_USUARIO_EQ);
        if (criterionUsuarioEq != null) {
            sql += " AND usuario.login = '" + criterionUsuarioEq + "'";
        }

        String criterionSenhaEq = (String) criteria.get(CRITERION_SENHA_EQ);
        if (criterionSenhaEq != null) {
            sql += " AND usuario.senha = '" + criterionSenhaEq + "'";
        }

        //Pesquisa por nome do usuário
        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()) {
            sql += " AND lower(usuario.nome) ilike '%" + criterionNomeILike + "%'";
        }

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Usuario e;
            String tipo = rs.getString("tipo");
            if (tipo.equalsIgnoreCase(TIPO_ADMINISTRADOR)) {
                e = new Administrador();
            } else {
                if (tipo.equalsIgnoreCase(TIPO_FINANCEIRO)) {
                    e = new Financeiro();
                } else {
                    e = new Solicitante();
                }
            }
            e.setId(rs.getLong("id"));
            e.setTipo(rs.getString("tipo"));
            e.setLogin(rs.getString("login"));
            e.setSenha(rs.getString("senha"));
            e.setNome(rs.getString("nome"));
            e.setCpf(rs.getLong("cpf"));
            e.setRg(rs.getString("rg"));
            e.setEmailCorporativo(rs.getString("emailCorporativo"));
            e.setEmailPessoal(rs.getString("emailPessoal"));
            e.setTelefoneCorporativo(rs.getString("telefoneCorporativo"));
            e.setTelefonePessoal(rs.getString("telefonePessoal"));

            //empresa
            Empresa empresa = new Empresa();
            empresa.setId(rs.getLong("empresa_id"));
            empresa.setNome(rs.getString("empresa_nome"));
            e.setEmpresa(empresa);

            lista.add(e);
        }
        rs.close();
        s.close();

        return lista;
    }

    @Override
    public void update(Usuario e, Connection conn) throws Exception {
        String sql = "UPDATE usuario SET empresa_fk=?, nome=?, senha=?, cpf=?, rg=?, tipo=?, emailpessoal=?, emailcorporativo=?, telefonepessoal=?, telefonecorporativo=?, login=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, e.getEmpresa().getId());
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getSenha());
        ps.setLong(++i, e.getCpf());
        ps.setString(++i, e.getRg());
        ps.setString(++i, e.getTipo());
        if (e.getEmailPessoal() != null) {
            ps.setString(++i, e.getEmailPessoal());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getEmailCorporativo() != null) {
            ps.setString(++i, e.getEmailCorporativo());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getTelefonePessoal() != null) {
            ps.setString(++i, e.getTelefonePessoal());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getTelefoneCorporativo() != null) {
            ps.setString(++i, e.getTelefoneCorporativo());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        ps.setString(++i, e.getLogin());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM usuario WHERE id = " + id + ";");
        st.close();
    }

    private String getTipo(Usuario e) {
        String tipo = "";
        if (e instanceof Financeiro) {
            tipo = TIPO_FINANCEIRO;
        } else {
            if (e instanceof Solicitante) {
                tipo = TIPO_SOLICITANTE;
            } else {
                if (e instanceof Administrador) {
                    tipo = TIPO_ADMINISTRADOR;
                }
            }
        }
        return tipo;
    }
}
