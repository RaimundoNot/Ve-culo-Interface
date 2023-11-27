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
	    car.calcIpva(); 
	    JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
	    list.add(car);
	}

	public void listar() {
		if (list.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
		} else {
			for (Carro c : list) {
				JOptionPane.showMessageDialog(null,
						"Modelo: " + c.getModelo() + "\nAno: " + c.getAno() + "\nValor: R$ " + c.getValor());
			}
		}
	}

	public Carro buscar(String modelo, boolean exibirMensagem) {
		for (Carro c : list) {
			if (c.getModelo().equals(modelo)) {
				if (exibirMensagem) {
					JOptionPane.showMessageDialog(null, "Carro encontrado: " + c.getModelo());
				}
				return c;
			}
		}
		if (exibirMensagem) {
			JOptionPane.showMessageDialog(null, "Carro não encontrado.");
		}
		return null;
	}

	public void atualizar(String modelo, String novoModelo, int novoAno, double novoValor) {
		Carro carro = buscar(modelo, false);
		if (carro != null) {
			carro.setModelo(novoModelo);
			carro.setAno(novoAno);
			carro.setValor(novoValor);
			JOptionPane.showMessageDialog(null, "Dados atualizados");
		}
	}
	
	public void deletar(String modelo) {
	    Carro carro = buscar(modelo, false);
	    if (carro != null) {
	        list.remove(carro);
	        JOptionPane.showMessageDialog(null, "Carro deletado");
	    } else {
	        JOptionPane.showMessageDialog(null, "Carro não encontrado");
	    }
	}

	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    for (Carro c : list) {
	        if (c != null) {
	            sb.append("R$ ").append(String.format("%.2f", c.calcIpva()));
	        }
	    }
	    return sb.toString();
	}

}
