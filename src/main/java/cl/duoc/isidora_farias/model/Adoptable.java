package cl.duoc.isidora_farias.model;

public interface Adoptable {
    /**
     * Indica si el animal se encuentra disponible para ser adoptado.
     *
     * @return true si está disponible para adopción
     */
    boolean estaDisponibleParaAdopcion();

    /**
     * Registra que el animal está disponible para adopción.
     */
    void marcarDisponibleParaAdopcion();
}
