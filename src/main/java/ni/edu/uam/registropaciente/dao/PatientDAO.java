package ni.edu.uam.registropaciente.dao;

import ni.edu.uam.registropaciente.modelos.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    List<Patient> pacientes;

    public PatientDAO(){
        pacientes = new ArrayList<>();
    }

    public void agregarPaciente(Patient patient){
        pacientes.add(patient);
    }

    public List<Patient> listarPacientes(){
        return pacientes;
    }
}
