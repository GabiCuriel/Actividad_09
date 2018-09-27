package main;

import view.ViewCyD;
import model.ModelCyD;
import controller.ControllerCyD;

public class MainCyD {
    private static ViewCyD viewCyD;
    private static ModelCyD modelCyD;
    private static ControllerCyD controllerCyD;
    
    public static void main(String[] args)
    {
        viewCyD = new ViewCyD();
        modelCyD = new ModelCyD();
        controllerCyD = new ControllerCyD(viewCyD, modelCyD);
    }
}
