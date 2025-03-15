package org.juan.empresas.services;

import org.juan.empresas.models.Empresa;

import java.util.List;

public interface EmpresaService {

    public List<Empresa> getBussines() throws RuntimeException;
}
