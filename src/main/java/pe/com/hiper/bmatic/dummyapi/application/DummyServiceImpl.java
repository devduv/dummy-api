package pe.com.hiper.bmatic.dummyapi.application;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import pe.com.hiper.bmatic.dummyapi.domain.customer.dto.CustomerResponseDTO;
import pe.com.hiper.bmatic.dummyapi.domain.customer.model.CustomerRequest;
import pe.com.hiper.bmatic.dummyapi.dummy.DummyData;

@Service
public class DummyServiceImpl implements DummyService {

	@Override
	public CustomerResponseDTO segmentationToHost(String documentId, String documentType, String attentionArea) {
		CustomerResponseDTO customerResponseDTO = null;
		if (findCustomer(documentId)) {
			CustomerRequest customer = CustomerRequest.builder().documentId(documentId).documentType(documentType)
					.attentionArea(attentionArea).build();
			customerResponseDTO = dummyFactory(customer);
		}
	
		return customerResponseDTO;
	}

	private boolean findCustomer(String documentId) {
		int i = 0;
		while (i < DummyData.documents.length) {
			if (DummyData.documents[i].equals(documentId)) {
				return true;
			}
			i++;
		}
		return false;
	}

	private CustomerResponseDTO dummyFactory(CustomerRequest customer) {
		String nombreCompleto = this.getCustomerName(customer.getDocumentId());
		String segmentoCliente = this.getSegmentation();
		String[] messages = this.getMessages(customer.getDocumentType());
		String codigoAgencia = getBranchId();
		String codigoFuncionario = getTellerId();

		if (messages != null) {
			return CustomerResponseDTO.builder().nombreCompleto(nombreCompleto).segmentoCliente(segmentoCliente)
					.mensaje1(messages[0]).mensaje2(messages[1]).mensaje3(messages[2]).mensaje4(messages[3])
					.publicidad("pig.png").codigoAgencia(codigoAgencia).codigoFuncionario(codigoFuncionario)
					.metadata(getMetadata()).build();
		} else {
			return CustomerResponseDTO.builder().nombreCompleto(nombreCompleto).segmentoCliente(segmentoCliente)
					.publicidad("pig.png").codigoAgencia(codigoAgencia).codigoFuncionario(codigoFuncionario)
					.metadata(getMetadata()).build();
		}
	}

	private String getCustomerName(String documentId) {
		if (documentId.equals("99999999")) {
			return "azAZñÑÁÉÍÓÚáéíóúD'lucasüÜ";
		} else {
			int sizeName = DummyData.names.length;
			int sizeLastname = DummyData.lastnames.length;
			int indexName = (int) (Math.random() * sizeName);
			int indexLastname = (int) (Math.random() * sizeLastname);
			return DummyData.names[indexName] + " " + DummyData.lastnames[indexLastname];
		}
		

		
	}

	private String getSegmentation() {
		int index = (int) (Math.random() * DummyData.segments.length);
		return DummyData.segments[index];
	}

	private String[] getMessages(String documentType) {
		if (documentType.equals("T")) {
			return DummyData.messagesT;
		} else if (documentType.equals("DNI")) {
			return DummyData.messagesD;
		} else if (documentType.equals("F")) {
			return DummyData.messagesF;
		}
		return null;
	}

	private String getBranchId() {
		return "F000" + (int) (Math.random() * 9);
	}

	private String getTellerId() {
		return "U0000" + (int) (Math.random() * 9);
	}

	private Map<String, String> getMetadata() {
		Map<String, String> metadata = new HashMap<String, String>();
		metadata.put("esDigital", "true");
		metadata.put("fechaRegistro", "04-01-2021");
		return metadata;
	}
}
