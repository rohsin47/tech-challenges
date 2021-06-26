/**
 * 
 */
package com.crypto.app.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crypto.app.model.Position;
import com.crypto.app.service.IPositionService;

/**
 * @author rohsi
 *
 */
@Service
public class PositionService implements IPositionService {

	@Override
	public List<Position> getPositions(InputStream inputStream) {
		List<Position> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        records.add(new Position(values[0], Double.valueOf(values[1]), Integer.valueOf(values[2]), values[3], values[4]));
		    }
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return records;
	}

}
