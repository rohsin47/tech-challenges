package com.crypto.app.service;

import java.io.InputStream;
import java.util.List;

import com.crypto.app.model.Position;

/**
 * @author rohsi
 *
 */
@FunctionalInterface
public interface IPositionService {
	
	List<Position> getPositions(InputStream inputStream);

}
