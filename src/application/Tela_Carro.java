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

public class Tela_Carro implements ActionListener {

	JFrame tela = new JFrame("Cadastro de Veículos");
	JPanel painel = new JPanel();

	JLabel lbmodelo = new JLabel("Modelo: ");
	JTextField textModel = new JTextField();
	JLabel lbano = new JLabel("Ano: ");
	JTextField textAno = new JTextField();
	JLabel lbvalor = new JLabel("Valor: ");
	JTextField textVal = new JTextField();
	JLabel lbIpva = new JLabel("IPVA: ");
	JTextField textIpva = new JTextField();
	JTextField textBuscar = new JTextField();
	
	JButton salvar = new JButton("Salvar");
	JButton btlistar = new JButton("Listar");
	JButton deletar = new JButton("Deletar");
	JButton atualizar = new JButton("Atualizar");
	JButton buscar = new JButton("Buscar");
	

	Carro car = new Carro();
	carroController cc = new carroController();

	String modelo = "";
	Integer ano = 0;
	Double valor = 0.0;
	Double ipva = 0.0;

	void Tela() {

		tela.setSize(400, 250);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLocationRelativeTo(null);

		painel.setLayout(null);

		lbmodelo.setBounds(10, 10, 100, 30);
		painel.add(lbmodelo);

		textModel.setBounds(70, 15, 120, 20);
		painel.add(textModel);

		lbano.setBounds(10, 40, 100, 30);
		painel.add(lbano);

		textAno.setBounds(70, 45, 120, 20);
		painel.add(textAno);

		lbvalor.setBounds(10, 70, 100, 30);
		painel.add(lbvalor);

		lbIpva.setBounds(10, 110, 100, 30);
		// lbIpva.setText(Double.parseDouble(car.calcIpva()));
		painel.add(lbIpva);

		textIpva.setBounds(70, 115, 120, 20);
		textIpva.disable();
		painel.add(textIpva);

		textVal.setBounds(70, 75, 120, 20);
		painel.add(textVal);

		textBuscar.setBounds(235, 15, 120, 20);
		painel.add(textBuscar);

		salvar.setBounds(10, 150, 75, 35);
		salvar.addActionListener(this);
		painel.add(salvar);

		btlistar.setBounds(90, 150, 75, 35);
		btlistar.addActionListener(this);
		painel.add(btlistar);

		deletar.setBounds(265, 150, 90, 35);
		deletar.addActionListener(this);
		painel.add(deletar);

		buscar.setBounds(255, 40, 75, 35);
		buscar.addActionListener(this);
		painel.add(buscar);

		atualizar.setBounds(170, 150, 90, 35);
		atualizar.addActionListener(this);
		painel.add(atualizar);

		tela.getContentPane().add(painel);
		tela.setVisible(true);
	}

	public static void main(String[] args) {
		Tela_Carro tp = new Tela_Carro();
		tp.Tela();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvar) {
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
			textIpva.setText("");
		}

		if (e.getSource() == btlistar) {
			cc.listar();
		}

		if (e.getSource() == deletar) {
		    String modelo = textModel.getText(); // substitua 'seuCampoDeTexto' pelo nome do seu campo de texto
		    cc.deletar(modelo);
		    textModel.setText("");
			textAno.setText("");
			textVal.setText("");
			textIpva.setText("");
		}

		if (e.getSource() == buscar) {
			Carro carroEncontrado = cc.buscar(textBuscar.getText(), true);
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

		if (e.getSource() == atualizar) {
			String modelo = textBuscar.getText();
			String novoModelo = textModel.getText();
			int novoAno = Integer.parseInt(textAno.getText());
			double novoValor = Double.parseDouble(textVal.getText());
			cc.atualizar(modelo, novoModelo, novoAno, novoValor);

			textModel.setText("");
			textAno.setText("");
			textVal.setText("");
			textBuscar.setText("");
		}

		if (textIpva != null) {
	
			textIpva.setText(cc.toString());
		}

	}
}
