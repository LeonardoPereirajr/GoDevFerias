package ferias;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//TODO: Documentar
public class FeriasRequerimento {
	String identificadorUsuario; // FK Foreign Key do usuário
	Ferias feriasRequisitada; // Instância de Férias
	String estadoRequisicao; // ENUM
	static short PRAZO_MINIMO_SOLICITACAO_FERIAS = 10;

	public FeriasRequerimento(String identificadorUsuario, Ferias feriasRequisitada) {
		this.identificadorUsuario = identificadorUsuario;
		this.feriasRequisitada = feriasRequisitada;
		this.estadoRequisicao = "Em Analise";
	}

	/*
	 * Atualiza o estado da requisição
	 * 
	 * Verifica se o novoEstado está registrado nas ENUMS do sistema Atualiza o
	 * estado do requerimento
	 * 
	 * @return true/false sucesso da operação.
	 */
	public boolean atualizarEstadoRequisicao(String novoEstado) {
		// Verificar se o estado é valido (dentro do ENUM);
		// se for, retornar falso

		// se nao for valido, verdadeiro
		this.estadoRequisicao = novoEstado;
		return true;
	}

	/**
	 * Retorna quantidade de dias
	 * 
	 * Retorna a quantidade de dias em formato long, a partir das datas de início e
	 * término informadas.
	 * 
	 * @param inicio  Data de início.
	 * @param termino Data de término.
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
