package pe.com.hiper.bmatic.dummyapi.domain.customer.dto;

import java.util.Map;

public class CustomerResponseDTO {

	private String nombreCompleto;
	private String segmentoCliente;
	private String mensaje1;
	private String mensaje2;
	private String mensaje3;
	private String mensaje4;
	private String publicidad;
	private String codigoAgencia;
	private String codigoFuncionario;
	private Map<String, String> metadata;

	public CustomerResponseDTO(String nombreCompleto, String segmentoCliente, String mensaje1, String mensaje2,
			String mensaje3, String mensaje4, String publicidad, String codigoAgencia, String codigoFuncionario,
			Map<String, String> metadata) {
		this.nombreCompleto = nombreCompleto;
		this.segmentoCliente = segmentoCliente;
		this.mensaje1 = mensaje1;
		this.mensaje2 = mensaje2;
		this.mensaje3 = mensaje3;
		this.mensaje4 = mensaje4;
		this.publicidad = publicidad;
		this.codigoAgencia = codigoAgencia;
		this.codigoFuncionario = codigoFuncionario;
		this.metadata = metadata;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getSegmentoCliente() {
		return segmentoCliente;
	}

	public String getMensaje1() {
		return mensaje1;
	}
	public String getMensaje2() {
		return mensaje2;
	}

	public String getMensaje3() {
		return mensaje3;
	}
	public String getMensaje4() {
		return mensaje4;
	}

	public String getPublicidad() {
		return publicidad;
	}
	public String getCodigoAgencia() {
		return codigoAgencia;
	}

	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public static CustomerResponseDTOBuilder builder() {
		return new CustomerResponseDTOBuilder();
	}

	public static class CustomerResponseDTOBuilder {
		private String nombreCompleto;
		private String segmentoCliente;
		private String mensaje1;
		private String mensaje2;
		private String mensaje3;
		private String mensaje4;
		private String publicidad;
		private String codigoAgencia;
		private String codigoFuncionario;
		private Map<String, String> metadata;

		public CustomerResponseDTOBuilder nombreCompleto(String nombreCompleto) {
			this.nombreCompleto = nombreCompleto;
			return this;
		}

		public CustomerResponseDTOBuilder segmentoCliente(String segmentoCliente) {
			this.segmentoCliente = segmentoCliente;
			return this;
		}

		public CustomerResponseDTOBuilder mensaje1(String mensaje1) {
			this.mensaje1 = mensaje1;
			return this;
		}

		public CustomerResponseDTOBuilder mensaje2(String mensaje2) {
			this.mensaje2 = mensaje2;
			return this;
		}

		public CustomerResponseDTOBuilder mensaje3(String mensaje3) {
			this.mensaje3 = mensaje3;
			return this;
		}

		public CustomerResponseDTOBuilder mensaje4(String mensaje4) {
			this.mensaje4 = mensaje4;
			return this;
		}

		public CustomerResponseDTOBuilder publicidad(String publicidad) {
			this.publicidad = publicidad;
			return this;
		}

		public CustomerResponseDTOBuilder codigoAgencia(String codigoAgencia) {
			this.codigoAgencia = codigoAgencia;
			return this;
		}

		public CustomerResponseDTOBuilder codigoFuncionario(String codigoFuncionario) {
			this.codigoFuncionario = codigoFuncionario;
			return this;
		}

		public CustomerResponseDTOBuilder metadata(Map<String, String> metadata) {
			this.metadata = metadata;
			return this;
		}

		public CustomerResponseDTO build() {
			return new CustomerResponseDTO(nombreCompleto, segmentoCliente, mensaje1, mensaje2, mensaje3, mensaje4,
					publicidad, codigoAgencia, codigoFuncionario, metadata);
		}
	}

	@Override
	public String toString() {
		return "CustomerResponseDTO [nombreCompleto=" + nombreCompleto + ", segmentoCliente=" + segmentoCliente
				+ ", mensaje1=" + mensaje1 + ", mensaje2=" + mensaje2 + ", mensaje3=" + mensaje3 + ", mensaje4="
				+ mensaje4 + ", publicidad=" + publicidad + ", codigoAgencia=" + codigoAgencia + ", codigoFuncionario="
				+ codigoFuncionario + ", metadata=" + metadata + "]";
	}

}
