package ferias;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//TODO: Documentar
public class FeriasRequerimento {
	String identificadorUsuario; // FK Foreign Key do usu�rio
	Ferias feriasRequisitada; // Inst�ncia de F�rias
	String estadoRequisicao; // ENUM
	static short PRAZO_MINIMO_SOLICITACAO_FERIAS = 10;

	public FeriasRequerimento(String identificadorUsuario, Ferias feriasRequisitada) {
		this.identificadorUsuario = identificadorUsuario;
		this.feriasRequisitada = feriasRequisitada;
		this.estadoRequisicao = "Em Analise";
	}

	/*
	 * Atualiza o estado da requisi��o
	 * 
	 * Verifica se o novoEstado est� registrado nas ENUMS do sistema Atualiza o
	 * estado do requerimento
	 * 
	 * @return true/false sucesso da opera��o.
	 */
	public boolean atualizarEstadoRequisicao(String novoEstado) {
		// Verificar se o estado � valido (dentro do ENUM);
		// se for, retornar falso

		// se nao for valido, verdadeiro
		this.estadoRequisicao = novoEstado;
		return true;
	}

	/**
	 * Retorna quantidade de dias
	 * 
	 * Retorna a quantidade de dias em formato long, a partir das datas de in�cio e
	 * t�rmino informadas.
	 * 
	 * @param inicio  Data de in�cio.
	 * @param termino Data de t�rmino.
	 * @return
	 */
	public static short retornarIntervaloEmDiasEntreAsDatas(LocalDate inicio, LocalDate termino) {
		short dias = (short) ChronoUnit.DAYS.between(inicio, termino);
		return dias;
	}

	/**
	 * 
	 * @param dataInicioFerias
	 * @return
	 */

	public static boolean validacaoParaSolicitacaoDeFerias(LocalDate dataInicioFerias) {
		if (retornarIntervaloEmDiasEntreAsDatas(LocalDate.now(),dataInicioFerias) > PRAZO_MINIMO_SOLICITACAO_FERIAS) {
			return true;
		} else {
			return false;
		}

	}

}
