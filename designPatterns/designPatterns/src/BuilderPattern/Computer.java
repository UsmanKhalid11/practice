package BuilderPattern;

public class Computer {

    private String cpu;
    private String ram;
    private String gpu;
    private String hardDisk;

    private Computer( ComputerBuilder computerBuilder){
        this.cpu=computerBuilder.cpu;
        this.ram=computerBuilder.ram;
        this.gpu=computerBuilder.gpu;
        this.hardDisk=computerBuilder.hardDisk;

    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", gpu='" + gpu + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                '}';
    }

    public static class ComputerBuilder{
        private String cpu;
        private String ram;
        private String gpu;
        private String hardDisk;



        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public ComputerBuilder setHardDisk(String hardDisk) {
            this.hardDisk = hardDisk;
            return this;
        }
        public Computer build(){
            return new Computer(this);
        }
    }


}
