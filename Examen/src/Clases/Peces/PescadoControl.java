package Clases.Peces;

public class PescadoControl extends Thread{
    private PescadoEntity pescadoEntity = null;

    public PescadoControl(PescadoEntity pescadoEntity) {
        this.pescadoEntity = pescadoEntity;
    }

    @Override
    public void run() {
        int incrementoX = 1;
        int incrementoY = 1;

        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (pescadoEntity.getLaPosicion().getX() >= 1000){
                incrementoX = -1;
            }
            if (pescadoEntity.getLaPosicion().getY() >= 500){
                incrementoY = -1;
            }
            if (pescadoEntity.getLaPosicion().getX() <= 0){
                incrementoX = 1;
            }
            if (pescadoEntity.getLaPosicion().getY() <= 0){
                incrementoY = 1;
            }
            pescadoEntity.getLaPosicion().setX(pescadoEntity.getLaPosicion().getX() + incrementoX);
            pescadoEntity.getLaPosicion().setY(pescadoEntity.getLaPosicion().getY() + incrementoY);
        }
    }
}
