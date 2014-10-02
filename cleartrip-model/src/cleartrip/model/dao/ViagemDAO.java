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
                + "valoradiantamento, valorreembolso, valorressarciamento, nreciboadiantamento,"
                + "nreciboressarciamento, relatoviagem, dataaprovacao, dataencerramento)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, e.getUsuario().getId());
        ps.setLong(++i, e.getTransporte().getId());
        ps.setString(++i, e.getStatus());
        ps.setString(++i, e.getDestino());
        if (e.getMotivo() != null) {
            ps.setString(++i, e.getMotivo());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        ps.setString(++i, e.getEnderecoDestino());
        ps.setString(++i, e.getTelefoneDestino());
        if (e.getOutrosMateriais() != null) {
            ps.setString(++i, e.getOutrosMateriais());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        ps.setString(++i, e.getCidadePartida());
        ps.setString(++i, e.getEnderecoPartida());
        ps.setString(++i, e.getTelefonePartida());
        ps.setDate(++i, e.getDataPartida());
        ps.setTime(++i, e.getHoraPartida());
        if (e.getAeroportoIda() != null) {
            ps.setString(++i, e.getAeroportoIda());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getCiaAereaIda() != null) {
            ps.setString(++i, e.getCiaAereaIda());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getNumeroVooIda() != null) {
            ps.setString(++i, e.getNumeroVooIda());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getDataCompromisso() != null) {
            ps.setDate(++i, e.getDataCompromisso());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        if (e.getHoraCompromisso() != null) {
            ps.setTime(++i, e.getHoraCompromisso());
        } else {
            ps.setNull(++i, Types.TIME);
        }
        ps.setDate(++i, e.getDataVolta());
        ps.setTime(++i, e.getHoraVolta());
        if (e.getAeroportoVolta() != null) {
            ps.setString(++i, e.getAeroportoVolta());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getCiaAereaVolta() != null) {
            ps.setString(++i, e.getCiaAereaVolta());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getNumeroVooVolta() != null) {
            ps.setString(++i, e.getNumeroVooVolta());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getValorAdiantameto() != null) {
            ps.setDouble(++i, e.getValorAdiantameto());
        } else {
            ps.setNull(++i, Types.DOUBLE);
        }
        if (e.getValorReembolso() != null) {
            ps.setDouble(++i, e.getValorReembolso());
        } else {
            ps.setNull(++i, Types.DOUBLE);
        }
        if (e.getValorRessarcimento() != null) {
            ps.setDouble(++i, e.getValorRessarcimento());
        } else {
            ps.setNull(++i, Types.DOUBLE);
        }
        if (e.getRelatoViagem() != null) {
            ps.setString(++i, e.getRelatoViagem());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getDataAprovacao() != null) {
            ps.setDate(++i, e.getDataAprovacao());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        if (e.getDataEncerramento() != null) {
            ps.setDate(++i, e.getDataEncerramento());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        ps.execute();
        ps.close();
    }

    @Override
    public Viagem readById(Long id, Connection conn) throws Exception {
        Viagem e = null;
        String sql = "SELECT viagem.*, usuario.id, usuario.nome, meio_transporte.* FROM viagem LEFT JOIN usuario ON viagem.usuario_fk = usuario.id LEFT JOIN meio_transporte ON viagem.meio_transporte_fk = meio_transporte.id WHERE viagem.id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("viagem.id"));
            e.setStatus(rs.getString("viagem.status"));
            e.setDestino(rs.getString("viagem.destino"));
            e.setMotivo(rs.getString("viagem.motivo"));
            e.setEnderecoDestino(rs.getString("viagem.enderecodestino"));
            e.setTelefoneDestino(rs.getString("viagem.telefonedestino"));
            e.setOutrosMateriais(rs.getString("viagem.outrosmateriais"));
            e.setCidadePartida(rs.getString("viagem.cidadepartida"));
            e.setTelefonePartida(rs.getString("viagem.telefonepartida"));
            e.setDataPartida(rs.getDate("viagem.datapartida"));
            e.setHoraPartida(rs.getTime("viagem.horapartida"));
            e.setAeroportoIda(rs.getString("viagem.aeroportoida"));
            e.setCiaAereaIda(rs.getString("viagem.ciaaereaida"));
            e.setNumeroVooIda(rs.getString("viagem.numerovooida"));
            e.setDataCompromisso(rs.getDate("viagem.datacompromisso"));
            e.setHoraCompromisso(rs.getTime("viagem.horacompromisso"));
            e.setDataVolta(rs.getDate("viagem.datavolta"));
            e.setHoraVolta(rs.getTime("viagem.horavolta"));
            e.setAeroportoVolta(rs.getString("viagem.aeroportovolta"));
            e.setCiaAereaVolta(rs.getString("viagem.ciaaereavolta"));
            e.setNumeroVooVolta(rs.getString("viagem.numerovoovolta"));
            e.setValorAdiantameto(rs.getDouble("viagem.valoradiantamento"));
            e.setValorReembolso(rs.getDouble("viagem.valorreembolso"));
            e.setValorRessarcimento(rs.getDouble("viagem.valorressarcimento"));
            e.setNumeroReciboAdiantamento(rs.getString("viagem.nreciboadiantamento"));
            e.setNumeroReciboRessarcimento(rs.getString("viagem.nreciboressarcimento"));
            e.setRelatoViagem(rs.getString("viagem.relatoviagem"));
            e.setDataAprovacao(rs.getDate("viagem.dataaprovacao"));
            e.setDataEncerramento(rs.getDate("viagem.dataencerramento"));

            //Usuario
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario.id"));
            usuario.setNome(rs.getString("usuario.nome"));
            e.setUsuario(usuario);

            //Meio de transporte
            Transporte transporte = new Transporte();
            transporte.setId(rs.getLong("transporte.id"));
            transporte.setNome(rs.getString("transporte.nome"));
            e.setTransporte(transporte);
        }
        rs.close();
        ps.close();

        return e;
    }

    @Override
    public List<Viagem> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Viagem> lista = new ArrayList<Viagem>();

        String sql = "SELECT viagem.*, usuario.id, usuario.nome, meio_transporte.* FROM viagem LEFT JOIN usuario ON viagem.usuario_fk = usuario.id LEFT JOIN meio_transporte ON viagem.meio_transporte_fk = meio_transporte.id WHERE 1=1;";

        String criterionUsuarioEq = (String) criteria.get(CRITERION_USUARIO_EQ);
        if (criterionUsuarioEq != null && !criterionUsuarioEq.trim().isEmpty()) {
            sql += " AND lower(usuario.nome) ilike '%" + criterionUsuarioEq + "%'";
        }

        String criterionStatusEq = (String) criteria.get(CRITERION_STATUS_EQ);
        if (criterionStatusEq != null) {
            sql += " AND viagem.status = '"
                    + criterionStatusEq + "'";
        }
        /** PARA FAZER
        String criterionpartidaInicioEq = (String) criteria.get(CRITERION_DATA_PARTIDA_INICIO_EQ);
        String criterionPartidaFimEq = (String) criteria.get(CRITERION_DATA_PARTIDA_FIM_EQ);
        if (criterionpartidaInicioEq != null && criterionPartidaFimEq != null) {
            sql += " AND viagem.datapartida between"+ criterionpartidaInicioEq + " AND " + criterionPartidaFimEq+";";
        }
        * **/


        Statement s = conn.createStatement();
        ResultSet rs
                = s.executeQuery(sql);
        while (rs.next()) {
            Viagem e = new Viagem();
            e.setId(rs.getLong("viagem.id"));
            e.setStatus(rs.getString("viagem.status"));
            e.setDestino(rs.getString("viagem.destino"));
            e.setMotivo(rs.getString("viagem.motivo"));
            e.setEnderecoDestino(rs.getString("viagem.enderecodestino"));
            e.setTelefoneDestino(rs.getString("viagem.telefonedestino"));
            e.setOutrosMateriais(rs.getString("viagem.outrosmateriais"));
            e.setCidadePartida(rs.getString("viagem.cidadepartida"));
            e.setTelefonePartida(rs.getString("viagem.telefonepartida"));
            e.setDataPartida(rs.getDate("viagem.datapartida"));
            e.setHoraPartida(rs.getTime("viagem.horapartida"));
            e.setAeroportoIda(rs.getString("viagem.aeroportoida"));
            e.setCiaAereaIda(rs.getString("viagem.ciaaereaida"));
            e.setNumeroVooIda(rs.getString("viagem.numerovooida"));
            e.setDataCompromisso(rs.getDate("viagem.datacompromisso"));
            e.setHoraCompromisso(rs.getTime("viagem.horacompromisso"));
            e.setDataVolta(rs.getDate("viagem.datavolta"));
            e.setHoraVolta(rs.getTime("viagem.horavolta"));
            e.setAeroportoVolta(rs.getString("viagem.aeroportovolta"));
            e.setCiaAereaVolta(rs.getString("viagem.ciaaereavolta"));
            e.setNumeroVooVolta(rs.getString("viagem.numerovoovolta"));
            e.setValorAdiantameto(rs.getDouble("viagem.valoradiantamento"));
            e.setValorReembolso(rs.getDouble("viagem.valorreembolso"));
            e.setValorRessarcimento(rs.getDouble("viagem.valorressarcimento"));
            e.setNumeroReciboAdiantamento(rs.getString("viagem.nreciboadiantamento"));
            e.setNumeroReciboRessarcimento(rs.getString("viagem.nreciboressarcimento"));
            e.setRelatoViagem(rs.getString("viagem.relatoviagem"));
            e.setDataAprovacao(rs.getDate("viagem.dataaprovacao"));
            e.setDataEncerramento(rs.getDate("viagem.dataencerramento"));

            //Usuario
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario.id"));
            usuario.setNome(rs.getString("usuario.nome"));
            e.setUsuario(usuario);

            //Meio de transporte
            Transporte transporte = new Transporte();
            transporte.setId(rs.getLong("transporte.id"));
            transporte.setNome(rs.getString("transporte.nome"));
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
                + "SET id=?, usuario_fk=?, meio_transporte_fk=?, status=?, destino=?,"
                + "motivo=?, enderecodestino=?, telefonedestino=?, outrosmateriais=?,"
                + "cidadepartida=?, enderecopartida=?, telefonepartida=?, datapartida=?,"
                + "horapartida=?, aeroportoida=?, ciaaereaida=?, numerovooida=?,"
                + "datacompromisso=?, horacompromisso=?, datavolta=?, horavolta=?,"
                + "aeroportovolta=?, ciaaereavolta=?, numerovoovolta=?, valoradiantamento=?,"
                + "valorreembolso=?, valorressarciamento=?, nreciboadiantamento=?,"
                + "nreciboressarciamento=?, relatoviagem=?, dataaprovacao=?, dataencerramento=? "
                + "WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;

        ps.setLong(++i, e.getUsuario().getId());
        ps.setLong(++i, e.getTransporte().getId());
        ps.setString(++i, e.getStatus());
        ps.setString(++i, e.getDestino());
        if (e.getMotivo() != null) {
            ps.setString(++i, e.getMotivo());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        ps.setString(++i, e.getEnderecoDestino());
        ps.setString(++i, e.getTelefoneDestino());
        if (e.getOutrosMateriais() != null) {
            ps.setString(++i, e.getOutrosMateriais());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        ps.setString(++i, e.getCidadePartida());
        ps.setString(++i, e.getEnderecoPartida());
        ps.setString(++i, e.getTelefonePartida());
        ps.setDate(++i, e.getDataPartida());
        ps.setTime(++i, e.getHoraPartida());
        if (e.getAeroportoIda() != null) {
            ps.setString(++i, e.getAeroportoIda());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getCiaAereaIda() != null) {
            ps.setString(++i, e.getCiaAereaIda());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getNumeroVooIda() != null) {
            ps.setString(++i, e.getNumeroVooIda());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getDataCompromisso() != null) {
            ps.setDate(++i, e.getDataCompromisso());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        if (e.getHoraCompromisso() != null) {
            ps.setTime(++i, e.getHoraCompromisso());
        } else {
            ps.setNull(++i, Types.TIME);
        }
        ps.setDate(++i, e.getDataVolta());
        ps.setTime(++i, e.getHoraVolta());
        if (e.getAeroportoVolta() != null) {
            ps.setString(++i, e.getAeroportoVolta());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getCiaAereaVolta() != null) {
            ps.setString(++i, e.getCiaAereaVolta());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getNumeroVooVolta() != null) {
            ps.setString(++i, e.getNumeroVooVolta());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getValorAdiantameto() != null) {
            ps.setDouble(++i, e.getValorAdiantameto());
        } else {
            ps.setNull(++i, Types.DOUBLE);
        }
        if (e.getValorReembolso() != null) {
            ps.setDouble(++i, e.getValorReembolso());
        } else {
            ps.setNull(++i, Types.DOUBLE);
        }
        if (e.getValorRessarcimento() != null) {
            ps.setDouble(++i, e.getValorRessarcimento());
        } else {
            ps.setNull(++i, Types.DOUBLE);
        }
        if (e.getRelatoViagem() != null) {
            ps.setString(++i, e.getRelatoViagem());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        if (e.getDataAprovacao() != null) {
            ps.setDate(++i, e.getDataAprovacao());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        if (e.getDataEncerramento() != null) {
            ps.setDate(++i, e.getDataEncerramento());
        } else {
            ps.setNull(++i, Types.DATE);
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
