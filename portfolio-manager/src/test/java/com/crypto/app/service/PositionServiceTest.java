package com.crypto.app.service;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.crypto.app.model.Position;
import com.crypto.app.service.impl.PositionService;

/**
 * @author rohsingh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PositionServiceTest {

    @InjectMocks
    PositionService service;

    @Test
    public void shouldReturnPositions() throws UnsupportedEncodingException {
        // given
        String csvInput = "AAA,40,60,USD,Sell";
        InputStream inputStream = new ByteArrayInputStream(csvInput.getBytes("UTF-8"));

        // when
        List<Position> result = service.getPositions(inputStream);

        // then
        assertNotNull(result);
        assertFalse(result.isEmpty());

    }

}
