package com.example.beneficiariotest.service;

import com.example.beneficiariotest.dto.ConsultaInputDTO;
import com.example.beneficiariotest.model.Beneficiario;
import com.example.beneficiariotest.model.Consulta;
import com.example.beneficiariotest.model.Especialidade;
import com.example.beneficiariotest.repository.ConsultaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultaServiceImpl implements ConsultaService {
    private final ConsultaRepository repository;

    private final BeneficiarioService beneficiarioService;

    private final EspecialidadeService especialidadeService;

    public ConsultaServiceImpl(ConsultaRepository repository, BeneficiarioService beneficiarioService,
                               EspecialidadeService especialidadeService, ModelMapper modelMapper) {
        this.repository = repository;
        this.beneficiarioService = beneficiarioService;
        this.especialidadeService = especialidadeService;
        this.modelMapper = modelMapper;
    }

    private final ModelMapper modelMapper;

    @Override
    public List<Consulta> listarTodos() {
        return repository.findAll();
    }

    public void salvar(ConsultaInputDTO consultaInput) {
        Consulta consulta = modelMapper.map(consultaInput, Consulta.class);

        Beneficiario beneficiario = beneficiarioService.buscarPorCpfOrThrow(consultaInput.getCpfBeneficiario());
        Especialidade especialidade = especialidadeService.buscarPorNomeOrThrow(consultaInput.getNomeEspecialidade());

        consulta.setCodigoEspecialidade(especialidade.getId());

        repository.save(consulta);
    }

    @Override
    public void reset() {
        repository.deleteAll();
    }
}
