package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.entities.Carro;
import model.entities.carroController;

public class Tela_Carro implements ActionListener{
	
	JFrame tela = new JFrame("Cadastro de Veículos");
	JPanel painel = new JPanel();
	
	JLabel lbmodelo = new JLabel("Modelo: ");
	JTextField textModel = new JTextField();
	JLabel lbano = new JLabel("Ano: ");
	JTextField textAno = new JTextField();
	JLabel lbvalor = new JLabel("Valor: ");
	JTextField textVal = new JTextField();
	
	JButton salvar = new JButton("Salvar");
	JButton btlistar = new JButton("Listar");
	JButton cancelar = new JButton ("Cancelar");
	JButton buscar = new JButton("Buscar");
	JTextField textBuscar = new JTextField();
	
	Carro car = new Carro();
	carroController cc = new carroController();
	
	String modelo = "";
	Integer ano = 0;
	Double valor = 0.0;

	
	void Tela() {
		
		tela.setSize(400, 250);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLocationRelativeTo(null);
		
		painel.setLayout(null);
		
		
		lbmodelo.setBounds(10, 10, 100, 30);
		painel.add(lbmodelo);
		
		textModel.setBounds(70, 15, 120, 20);
		painel.add(textModel);
		
		
		lbano.setBounds(10, 50, 100, 30);
		painel.add(lbano);
		
		
		textAno.setBounds(70, 55, 120, 20);
		painel.add(textAno);
		
	
		lbvalor.setBounds(10, 90, 100, 30);
		painel.add(lbvalor);
		
	
		textVal.setBounds(70, 95, 120, 20);
		painel.add(textVal);
		
		textBuscar.setBounds(235, 15, 120, 20);
		painel.add(textBuscar);
		
		
		salvar.setBounds(10, 150, 75, 35);
		salvar.addActionListener(this);
		painel.add(salvar);
		
		
		btlistar.setBounds(90, 150, 75, 35);
		btlistar.addActionListener(this);
		painel.add(btlistar);
		
		cancelar.setBounds(170, 150, 90, 35);
		cancelar.addActionListener(this);
		painel.add(cancelar);
		
		buscar.setBounds(255, 40, 75, 35);
		buscar.addActionListener(this);
		painel.add(buscar);
		
		tela.getContentPane().add(painel);
		tela.setVisible(true);
	}
	
	public static void main(String[] args) {
		Tela_Carro tp = new Tela_Carro();
		tp.Tela();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == salvar) {
			modelo = textModel.getText();
			ano = Integer.parseInt(textAno.getText());
			valor = Double.parseDouble(textVal.getText());
			
			car.setModelo(modelo);
			car.setAno(ano);
			car.setValor(valor);
			
			cc.inserir(car);

			textModel.setText("");
			textAno.setText("");
			textVal.setText("");
		}
		
		if(e.getSource() == btlistar) {
			cc.listar();
		}
		
		if(e.getSource() == cancelar) {
			tela.dispose();
		}
		
		if(e.getSource() == buscar) {
		    Carro carroEncontrado = cc.buscar(textBuscar.getText());
		    if (carroEncontrado != null) {
		        textModel.setText(carroEncontrado.getModelo());
		        textAno.setText(String.valueOf(carroEncontrado.getAno()));
		        textVal.setText(String.valueOf(carroEncontrado.getValor()));
		    } else {
		        textModel.setText("");
		        textAno.setText("");
		        textVal.setText("");
		        textBuscar.setText("");
		    }
		}
	}

}
