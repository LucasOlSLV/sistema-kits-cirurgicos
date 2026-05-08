package model;

import java.util.List;
import java.util.ArrayList;
public class KitCirurgico {

    private String paciente;
    private String tipoCirurgia;
    private String status;

    private List<Item>itens;

    public KitCirurgico(String paciente, String tipoCirurgia){
        this.paciente = paciente;
        this.tipoCirurgia = tipoCirurgia;
        this.status = "EM ANALISE";
        this.itens = new ArrayList<>();
        montarKitAutomatico();
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }

    public void adicionarItem(Item item){
        itens.add(item);
}
    public String getPaciente() {
        return paciente;
    }

    public String getTipoCirurgia() {
        return tipoCirurgia;
    }

    public String getStatus() {
        return status;
    }

    public List<Item> getItens() {
        return itens;
    }

    private void montarKitAutomatico() {

        if (tipoCirurgia.equalsIgnoreCase("ombro")) {

            adicionarItem(new Item("Seringa", 2));
            adicionarItem(new Item("Luva", 4));
            adicionarItem(new Item("Anestesia", 1));

        } else if (tipoCirurgia.equalsIgnoreCase("cardiaca")) {

            adicionarItem(new Item("Bisturi", 2));
            adicionarItem(new Item("Campo Cirurgico", 5));
            adicionarItem(new Item("Soro", 3));

        } else {

            System.out.println("Tipo de cirurgia não padronizado.");
        }
    }

}
