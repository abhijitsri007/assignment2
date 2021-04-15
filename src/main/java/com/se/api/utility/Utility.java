package com.se.api.utility;

import com.ul.model.QAResponse;
import lombok.experimental.UtilityClass;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@UtilityClass
public class Utility {

    public static String Base64Encoding(String originalInput) {
        return Base64.getEncoder().encodeToString(originalInput.getBytes());
    }

    public static String Base64Decoding(String encodedString) {
        return new String(Base64.getDecoder().decode(encodedString));
    }

    public List<Long> mapRandomNoList() {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        int randomWithRandomDataGenerator = randomDataGenerator.nextInt(2, 5);
        QAResponse qaResponse = new QAResponse();
        List<Long> randomNumberList = new ArrayList<>();
        while (randomWithRandomDataGenerator > 0) {
            randomNumberList.add(randomDataGenerator.nextLong(1, 10));
            randomWithRandomDataGenerator--;
        }
        return randomNumberList;
    }
}
