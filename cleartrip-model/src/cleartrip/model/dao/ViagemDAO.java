package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.Transporte;
import cleartrip.model.pojo.Usuario;
import cleartrip.model.pojo.Viagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViagemDAO implements BaseDAO<Viagem> {

    public static final String CRITERION_STATUS_EQ = "1";
    public static final String CRITERION_USUARIO_ID = "2";
    public static final String CRITERION_USUARIO_EQ = "3";
    public static final String CRITERION_DATA_PARTIDA_INICIO_EQ = "4";
    public static final String CRITERION_DATA_PARTIDA_FIM_EQ = "5";

    @Override
    public void create(Viagem e, Connection conn) throws Exception {
        String sql = "INSERT INTO viagem("
                + "usuario_fk, meio_transporte_fk, status, destino, motivo,"
                + "enderecodestino, telefonedestino, outrosmateriais, cidadepartida,"
                + "enderecopartida, telefonepartida, datapartida, horapartida, aeroportoida,"
                + "ciaaereaida, numerovooida, datacompromisso, horacompromisso,"
                + "datavolta, horavolta, aeroportovolta, ciaaereavolta, numerovoovolta,"
                + "relatoviagem) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, e.getUsuario().getId());
        ps.setLong(++i, e.getTransporte().getId());
        ps.setString(++i, e.getStatus());
        ps.setString(++i, e.getDestino());

        if (e.getMotivo() != null || !e.getMotivo().isEmpty()) {
            ps.setString(++i, e.getMotivo());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        ps.setString(++i, e.getEnderecoDestino());
        ps.setString(++i, e.getTelefoneDestino());

        if (e.getOutrosMateriais() != null || !e.getOutrosMateriais().isEmpty()) {
            ps.setString(++i, e.getOutrosMateriais());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        ps.setString(++i, e.getCidadePartida());
        ps.setString(++i, e.getEnderecoPartida());
        ps.setString(++i, e.getTelefonePartida());
        ps.setString(++i, e.getDataPartida());
        ps.setString(++i, e.getHoraPartida());

        if (e.getAeroportoIda() != null || !e.getAeroportoIda().isEmpty()) {
            ps.setString(++i, e.getAeroportoIda());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getCiaAereaIda() != null || !e.getCiaAereaIda().isEmpty()) {
            ps.setString(++i, e.getCiaAereaIda());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getNumeroVooIda() != null || !e.getNumeroVooIda().isEmpty()) {
            ps.setString(++i, e.getNumeroVooIda());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getDataCompromisso() != null || !e.getDataCompromisso().isEmpty()) {
            ps.setString(++i, e.getDataCompromisso());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getHoraCompromisso() != null || !e.getHoraCompromisso().isEmpty()) {
            ps.setString(++i, e.getHoraCompromisso());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        ps.setString(++i, e.getDataVolta());
        ps.setString(++i, e.getHoraVolta());

        if (e.getAeroportoVolta() != null || !e.getAeroportoVolta().isEmpty()) {
            ps.setString(++i, e.getAeroportoVolta());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getCiaAereaVolta() != null || !e.getCiaAereaVolta().isEmpty()) {
            ps.setString(++i, e.getCiaAereaVolta());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getNumeroVooVolta() != null || !e.getNumeroVooVolta().isEmpty()) {
            ps.setString(++i, e.getNumeroVooVolta());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getRelatoViagem() != null || !e.getRelatoViagem().isEmpty()) {
            ps.setString(++i, e.getRelatoViagem());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        ps.execute();
        ps.close();
    }

    @Override
    public Viagem readById(Long id, Connection conn) throws Exception {
        Viagem e = null;
        String sql = "SELECT viagem.*, usuario.id as usuario_id, usuario.nome as usuario_nome, meio_transporte.id as meio_transporte_id, meio_transporte.nome as meio_transporte_nome FROM viagem LEFT JOIN usuario ON viagem.usuario_fk = usuario.id LEFT JOIN meio_transporte ON viagem.meio_transporte_fk = meio_transporte.id WHERE viagem.id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new Viagem();
            e.setId(rs.getLong("id"));
            e.setStatus(rs.getString("status"));
            e.setDestino(rs.getString("destino"));
            e.setMotivo(rs.getString("motivo"));
            e.setEnderecoDestino(rs.getString("enderecodestino"));
            e.setTelefoneDestino(rs.getString("telefonedestino"));
            e.setOutrosMateriais(rs.getString("outrosmateriais"));
            e.setCidadePartida(rs.getString("cidadepartida"));
            e.setEnderecoPartida(rs.getString("enderecopartida"));
            e.setTelefonePartida(rs.getString("telefonepartida"));
            e.setDataPartida(rs.getString("datapartida"));
            e.setHoraPartida(rs.getString("horapartida"));
            e.setAeroportoIda(rs.getString("aeroportoida"));
            e.setCiaAereaIda(rs.getString("ciaaereaida"));
            e.setNumeroVooIda(rs.getString("numerovooida"));
            e.setDataCompromisso(rs.getString("datacompromisso"));
            e.setHoraCompromisso(rs.getString("horacompromisso"));
            e.setDataVolta(rs.getString("datavolta"));
            e.setHoraVolta(rs.getString("horavolta"));
            e.setAeroportoVolta(rs.getString("aeroportovolta"));
            e.setCiaAereaVolta(rs.getString("ciaaereavolta"));
            e.setNumeroVooVolta(rs.getString("numerovoovolta"));
            e.setValorAdiantameto(rs.getDouble("valoradiantamento"));
            e.setValorReembolso(rs.getDouble("valorreembolso"));
            e.setValorRessarcimento(rs.getDouble("valorressarcimento"));
            e.setNumeroReciboAdiantamento(rs.getString("nreciboadiantamento"));
            e.setNumeroReciboRessarcimento(rs.getString("nreciboressarcimento"));
            e.setRelatoViagem(rs.getString("relatoviagem"));
            e.setDataAprovacao(rs.getString("dataaprovacao"));
            e.setDataEncerramento(rs.getString("dataencerramento"));

            //Usuario
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_id"));
            usuario.setNome(rs.getString("usuario_nome"));
            e.setUsuario(usuario);

            //Meio de transporte
            Transporte transporte = new Transporte();
            transporte.setId(rs.getLong("meio_transporte_id"));
            transporte.setNome(rs.getString("meio_transporte_nome"));
            e.setTransporte(transporte);
        }
        rs.close();
        ps.close();

        return e;
    }

    @Override
    public List<Viagem> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Viagem> lista = new ArrayList<Viagem>();

        String sql = "SELECT viagem.*, usuario.id as usuario_id, usuario.nome as usuario_nome, meio_transporte.id as meio_transporte_id, meio_transporte.nome as meio_transporte_nome FROM viagem LEFT JOIN usuario ON viagem.usuario_fk = usuario.id LEFT JOIN meio_transporte ON viagem.meio_transporte_fk = meio_transporte.id WHERE 1=1";

        String criterionUsuarioEq = (String) criteria.get(CRITERION_USUARIO_EQ);
        if (criterionUsuarioEq != null && !criterionUsuarioEq.trim().isEmpty()) {
            sql += " AND lower(usuario.nome) ilike '%" + criterionUsuarioEq + "%'";
        }
        
        Long criterionUsuarioId = (Long) criteria.get(CRITERION_USUARIO_ID);
        if (criterionUsuarioId != null) {
            sql += " AND viagem.usuario_fk = " + criterionUsuarioId;
        }

        String criterionStatusEq = (String) criteria.get(CRITERION_STATUS_EQ);
        if (criterionStatusEq != null) {
            sql += " AND viagem.status = '"
                    + criterionStatusEq + "'";
        }
        /**
         * PARA FAZER String criterionpartidaInicioEq = (String)
         * criteria.get(CRITERION_DATA_PARTIDA_INICIO_EQ); String
         * criterionPartidaFimEq = (String)
         * criteria.get(CRITERION_DATA_PARTIDA_FIM_EQ); if
         * (criterionpartidaInicioEq != null && criterionPartidaFimEq != null) {
         * sql += " AND viagem.datapartida between"+ criterionpartidaInicioEq +
         * " AND " + criterionPartidaFimEq+";"; }
        * *
         */

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Viagem e = new Viagem();
            e.setId(rs.getLong("id"));
            e.setStatus(rs.getString("status"));
            e.setDestino(rs.getString("destino"));
            e.setMotivo(rs.getString("motivo"));
            e.setEnderecoDestino(rs.getString("enderecodestino"));
            e.setTelefoneDestino(rs.getString("telefonedestino"));
            e.setOutrosMateriais(rs.getString("outrosmateriais"));
            e.setCidadePartida(rs.getString("cidadepartida"));
            e.setTelefonePartida(rs.getString("telefonepartida"));
            e.setDataPartida(rs.getString("datapartida"));
            e.setHoraPartida(rs.getString("horapartida"));
            e.setAeroportoIda(rs.getString("aeroportoida"));
            e.setCiaAereaIda(rs.getString("ciaaereaida"));
            e.setNumeroVooIda(rs.getString("numerovooida"));
            e.setDataCompromisso(rs.getString("datacompromisso"));
            e.setHoraCompromisso(rs.getString("horacompromisso"));
            e.setDataVolta(rs.getString("datavolta"));
            e.setHoraVolta(rs.getString("horavolta"));
            e.setAeroportoVolta(rs.getString("aeroportovolta"));
            e.setCiaAereaVolta(rs.getString("ciaaereavolta"));
            e.setNumeroVooVolta(rs.getString("numerovoovolta"));
            e.setValorAdiantameto(rs.getDouble("valoradiantamento"));
            e.setValorReembolso(rs.getDouble("valorreembolso"));
            e.setValorRessarcimento(rs.getDouble("valorressarcimento"));
            e.setNumeroReciboAdiantamento(rs.getString("nreciboadiantamento"));
            e.setNumeroReciboRessarcimento(rs.getString("nreciboressarcimento"));
            e.setRelatoViagem(rs.getString("relatoviagem"));
            e.setDataAprovacao(rs.getString("dataaprovacao"));
            e.setDataEncerramento(rs.getString("dataencerramento"));

            //Usuario
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_id"));
            usuario.setNome(rs.getString("usuario_nome"));
            e.setUsuario(usuario);

            //Meio de transporte
            Transporte transporte = new Transporte();
            transporte.setId(rs.getLong("meio_transporte_id"));
            transporte.setNome(rs.getString("meio_transporte_nome"));
            e.setTransporte(transporte);

            lista.add(e);
        }
        rs.close();
        s.close();

        return lista;
    }

    @Override
    public void update(Viagem e, Connection conn) throws Exception {
        String sql = "UPDATE viagem"
                + " SET usuario_fk=?, meio_transporte_fk=?, status=?, destino=?,"
                + " motivo=?, enderecodestino=?, telefonedestino=?, outrosmateriais=?,"
                + " cidadepartida=?, enderecopartida=?, telefonepartida=?, datapartida=?,"
                + " horapartida=?, aeroportoida=?, ciaaereaida=?, numerovooida=?,"
                + " datacompromisso=?, horacompromisso=?, datavolta=?, horavolta=?,"
                + " aeroportovolta=?, ciaaereavolta=?, numerovoovolta=?, relatoviagem=?"
                + " WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, e.getUsuario().getId());
        ps.setLong(++i, e.getTransporte().getId());
        ps.setString(++i, e.getStatus());
        ps.setString(++i, e.getDestino());

        if (e.getMotivo() != null || !e.getMotivo().isEmpty()) {
            ps.setString(++i, e.getMotivo());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        ps.setString(++i, e.getEnderecoDestino());
        ps.setString(++i, e.getTelefoneDestino());

        if (e.getOutrosMateriais() != null || !e.getOutrosMateriais().isEmpty()) {
            ps.setString(++i, e.getOutrosMateriais());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        ps.setString(++i, e.getCidadePartida());
        ps.setString(++i, e.getEnderecoPartida());
        ps.setString(++i, e.getTelefonePartida());
        ps.setString(++i, e.getDataPartida());
        ps.setString(++i, e.getHoraPartida());

        if (e.getAeroportoIda() != null || !e.getAeroportoIda().isEmpty()) {
            ps.setString(++i, e.getAeroportoIda());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getCiaAereaIda() != null || !e.getCiaAereaIda().isEmpty()) {
            ps.setString(++i, e.getCiaAereaIda());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getNumeroVooIda() != null || !e.getNumeroVooIda().isEmpty()) {
            ps.setString(++i, e.getNumeroVooIda());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getDataCompromisso() != null || !e.getDataCompromisso().isEmpty()) {
            ps.setString(++i, e.getDataCompromisso());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getHoraCompromisso() != null || !e.getHoraCompromisso().isEmpty()) {
            ps.setString(++i, e.getHoraCompromisso());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        ps.setString(++i, e.getDataVolta());
        ps.setString(++i, e.getHoraVolta());

        if (e.getAeroportoVolta() != null || !e.getAeroportoVolta().isEmpty()) {
            ps.setString(++i, e.getAeroportoVolta());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getCiaAereaVolta() != null || !e.getCiaAereaVolta().isEmpty()) {
            ps.setString(++i, e.getCiaAereaVolta());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getNumeroVooVolta() != null || !e.getNumeroVooVolta().isEmpty()) {
            ps.setString(++i, e.getNumeroVooVolta());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }

        if (e.getRelatoViagem() != null || !e.getRelatoViagem().isEmpty()) {
            ps.setString(++i, e.getRelatoViagem());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM viagem WHERE id = " + id + ";");
        st.close();
    }
}
