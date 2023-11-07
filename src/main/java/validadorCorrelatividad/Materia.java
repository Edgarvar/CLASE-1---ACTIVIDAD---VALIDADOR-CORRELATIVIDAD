package validadorCorrelatividad;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nobre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<Materia>();
    }
    public String getNombre() {
        return nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void agregarCorrelativa(Materia materia){
        this.correlativas.add(materia);
    }

    public boolean puedeCursar(final Alumno alumno) {
        return this.correlativas.stream().allMatch(materiaCorrelativa -> alumno.tenesCorrelativas(materiaCorrelativa));
    }

    public boolean tieneCorrelativas() {
        return !this.correlativas.isEmpty();
    }
}
