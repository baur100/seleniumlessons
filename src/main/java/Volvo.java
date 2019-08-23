public class Volvo implements Car {
    private String modelName;
    @Override
    public void start() {
        System.out.println("Volvo stared");
    }

    @Override
    public void stop() {
        System.out.println("Volvo stopped");
    }

    @Override
    public void beep() {
        System.out.println("Beeeeeeeeeeep");
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
