public class Notas {
    private float nota1;
    private float nota2;
    private float nota3;
    private float media;
    private String situacao;

    public Notas(float nota1, float nota2, float nota3) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        calcularMedia();
        verificarSituacao();
    }

    public Notas() {
        
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
        calcularMedia();
        verificarSituacao();
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
        calcularMedia();
        verificarSituacao();
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
        calcularMedia();
        verificarSituacao();
    }

    public float getMedia() {
        return media;
    }

    public String getSituacao() {
        return situacao;
    }

    private void calcularMedia() {
        media = (nota1 + nota2 + nota3) / 3;
    }

    private void verificarSituacao() {
        if (media >= 6) {
            situacao = "Aprovado";
        } else {
            situacao = "Reprovado";
        }
    }
  
}
