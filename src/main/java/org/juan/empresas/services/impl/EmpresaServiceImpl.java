package org.juan.empresas.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.juan.empresas.models.Empresa;
import org.juan.empresas.repositories.EmpresaRepository;
import org.juan.empresas.services.EmpresaService;
import java.util.List;

@ApplicationScoped
public class EmpresaServiceImpl implements EmpresaService {

    @Inject
    EmpresaRepository repository;

    @Override
    public List<Empresa> getBussines() throws RuntimeException {
        return repository.getBussines();
    }
}
