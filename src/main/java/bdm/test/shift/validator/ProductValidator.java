package bdm.test.shift.validator;

import bdm.test.shift.controller.dto.ProductRequestDTO;
import bdm.test.shift.entity.*;
import bdm.test.shift.exception.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class ProductValidator {

    public Product checkAndIdentifyRequest(ProductRequestDTO productRequestDTO) {
        switch (productRequestDTO.getType()) {

            case ("computer"):
                String formFactor = productRequestDTO.getFormFactor();
                if (formFactor == null || formFactor.isEmpty() || !checkFormFactor(formFactor)) {
                    throw new IllegalInputComputerParametersException();
                }
                return new Computer();

            case ("laptop"):
                Integer size = productRequestDTO.getSize();
                if (size == null || !checkSize(size)) {
                    throw new IllegalInputLaptopParametersException();
                }
                return new Laptop();

            case ("monitor"):
                Float diagonal = productRequestDTO.getDiagonal();
                if (diagonal == null || !checkDiagonal(diagonal)) {
                    throw new IllegalInputMonitorParametersException();
                }
                return new Monitor();

            case ("hdd"):
                Integer capacity = productRequestDTO.getCapacity();
                if (capacity == null || !checkCapacity(capacity)) {
                    throw new IllegalInputHardDiskDriveParametersException();
                }
                return new HardDiskDrive();

            default:
                throw new IllegalTypeOfProductException();
        }
    }

    private boolean checkFormFactor(String testFormFactor) {
        List<String> rule = Arrays.asList("desktop", "nettop", "monoblock");
        for (String option : rule) {
            if (testFormFactor.equals(option)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkSize(Integer testSize) {
        int[] rule = {13, 14, 15, 17};
        for (int option : rule) {
            if (testSize.equals(option)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(Float testDiagonal) {
        return testDiagonal >= 10.1 && testDiagonal <= 49;
    }

    private boolean checkCapacity(Integer testCapacity) {
        return testCapacity >= 64 && testCapacity % 64 == 0;
    }

    public void checkInputRequiredType(String requiredType) {
        List<String> availableTypes = Arrays.asList("computer", "laptop", "monitor", "hdd");
        if (!availableTypes.contains(requiredType)) {
            throw new IllegalTypeOfProductException();
        }
    }
}
