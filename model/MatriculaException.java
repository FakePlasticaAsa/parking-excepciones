package model;

public class MatriculaException extends Exception {
    private String mensaje;
    private Matricula matricula;

    public MatriculaException(String mensaje, Matricula matricula) {
        super(mensaje);
        this.mensaje = mensaje;
        this.matricula = matricula;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Matricula getMatricula() {
        return matricula;
    }
}
