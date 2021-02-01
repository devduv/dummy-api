package pe.com.hiper.bmatic.dummyapi.domain.customer.model;

public class CustomerRequest {
	private String documentType;
	private String documentId;
	private String attentionArea;

	public CustomerRequest(String documentType, String documentId, String attentionArea) {
		this.documentType = documentType;
		this.documentId = documentId;
		this.attentionArea = attentionArea;
	}

	public String getDocumentType() {
		return documentType;
	}

	public String getDocumentId() {
		return documentId;
	}

	public String getAttentionArea() {
		return attentionArea;
	}
	
	public static CustomerResquestBuilder builder() {
		return new CustomerResquestBuilder();
	}
	
	public static class CustomerResquestBuilder {
		private String documentType;
		private String documentId;
		private String attentionArea;
		
		public CustomerResquestBuilder documentType(String documentType) {
			this.documentType = documentType;
			return this;
		}
		public CustomerResquestBuilder documentId(String documentId) {
			this.documentId = documentId;
			return this;
		}
		public CustomerResquestBuilder attentionArea(String attentionArea) {
			this.attentionArea = attentionArea;
			return this;
		}
		public CustomerRequest build() {
			return new CustomerRequest(documentType, documentId, attentionArea);
		}
		
	}

	@Override
	public String toString() {
		return "CustomerRequestDTO {" +
				"docType='" + documentType + '\'' +
				", docNumber='" + documentId + '\'' +
				'}';
	}
}
