package pe.com.hiper.bmatic.dummyapi.application;

import pe.com.hiper.bmatic.dummyapi.domain.customer.dto.CustomerResponseDTO;

public interface DummyService {

	public CustomerResponseDTO segmentationToHost(String documentId, String documentType, String attentionArea);
}
