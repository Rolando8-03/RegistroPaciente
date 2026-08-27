package ni.edu.uam.registropaciente.dao;

import ni.edu.uam.registropaciente.interfaces.Crud;
import ni.edu.uam.registropaciente.modelos.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientDAO implements Crud<Patient> {

    private final List<Patient> pacientes;

    public PatientDAO() {
        pacientes = new ArrayList<>();
    }

    @Override
    public void agregar(Patient entidad) {
        pacientes.add(entidad);
    }

    @Override
    public List<Patient> obtenerRegistros() {
        return pacientes;
    }
}
