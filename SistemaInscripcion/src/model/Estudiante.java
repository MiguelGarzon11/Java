package model;

public class Estudiante {
    private String id;
    private String nombreCompleto;
    private String documento;
    private String programa;
    private String celular;
    private String correo;
    private String semestre;
    private String universidad;

    public Estudiante() {}

    public Estudiante(String nombreCompleto, String documento, String programa, String celular, String correo, String semestre, String universidad ) {

        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
        this.programa = programa;
        this.celular = celular;
        this.correo = correo;
        this.semestre = semestre;
        this.universidad = universidad;

    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getPrograma() { return programa; }
    public void setPrograma(String programa) { this.programa = programa; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getSemestre() { return semestre; }
    public void setSemestre(String semestre) { this.semestre = semestre; }

    public String getUniversidad() { return universidad; }
    public void setUniversidad(String universidad) { this.universidad = universidad; }
}