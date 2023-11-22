package model.entities;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class carroController {

	public static ArrayList<Carro> list = new ArrayList<Carro>();
	
	
	public void inserir(Carro carro) {
		Carro car = new Carro();
		car.setModelo(carro.getModelo());
		car.setAno(carro.getAno());
		car.setValor(carro.getValor());
		//car.calcIpva();
		JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
		list.add(car);
	}
	
	public void listar() {
		if(list.isEmpty()){
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
		} else {
			for(Carro c : list) {
				JOptionPane.showMessageDialog(null,
				"Modelo: "+ c.getModelo() + "\nAno: " + c.getAno()+ "\nValor: R$ "+ c.getValor());
			}
		}
	}
	
	public Carro buscar(String modelo) {
	    for(Carro c : list) {
	        if (c.getModelo().equals(modelo)) {
	            JOptionPane.showMessageDialog(null, "Carro encontrado: " + c.getModelo());
	            return c;
	        }
	    }
	    JOptionPane.showMessageDialog(null, "Carro não encontrado.");
	    return null;
	}
	
}
