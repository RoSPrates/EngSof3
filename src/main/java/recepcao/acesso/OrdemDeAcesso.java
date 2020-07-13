package recepcao.acesso;

import pessoas.Pessoa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.SimpleFormatter;

public class OrdemDeAcesso {
    private Long id;
    private Pessoa solicitante;
    private Pessoa convidado;
    private Calendar dataEntrada;
    private Calendar dataSaida;

    public OrdemDeAcesso(Long id, Pessoa solicitante, Pessoa convidado, int dia, int mes, int ano) {
        this.gerarOrdem(solicitante, convidado, dia, mes, ano);
        this.id = id;
    }

    public void gerarOrdem(Pessoa solicitante, Pessoa convidado, int dia, int mes, int ano) {
        this.solicitante = solicitante;
        this.convidado = convidado;
        dataEntrada = Calendar.getInstance();
        this.setDataEntrada(dia, mes, ano);
        dataSaida = Calendar.getInstance();
        this.setDataSaida(this.dataEntrada.get(Calendar.DAY_OF_MONTH),
                this.dataEntrada.get(Calendar.MONTH),
                this.dataEntrada.get(Calendar.YEAR), 5);
    }

    public void setDataEntrada(int dia, int mes, int ano) {
        dataEntrada.set(Calendar.DAY_OF_MONTH, dia);
        dataEntrada.set(Calendar.MONTH, mes);
        dataEntrada.set(Calendar.YEAR, ano);
    }

    public void setDataSaida(int dia, int mes, int ano, int diasDePermanencia) {
        dataSaida.set(Calendar.DAY_OF_MONTH, dia);
        dataSaida.set(Calendar.MONTH, mes);
        dataSaida.set(Calendar.YEAR, ano);
        dataSaida.add(Calendar.DAY_OF_MONTH, diasDePermanencia);
    }

    public Long getId() {
        return this.id;
    }

    public Pessoa getSolicitante() {
        return this.solicitante;
    }

    public Pessoa getConvidado() {
        return this.convidado;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd'/'MM'/'yyyy");
        String s = "";
        s+= "Solicitante: "+ this.solicitante.getNome() + " "+ this.solicitante.getSobrenome()+"\n";
        s+= "Convidado: "+ this.convidado.getNome() + " "+ this.convidado.getSobrenome()+"\n";
        s+= "Data de Entrada: "+ format.format(this.dataEntrada.getTime())+"\n";
        s+= "Validade autorização: "+ format.format(this.dataEntrada.getTime())+"\n";
        return s;
    }
}
