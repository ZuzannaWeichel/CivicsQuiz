package com.pillar.civicsquiz.controller;

import com.pillar.civicsquiz.Inquiry;
import com.pillar.civicsquiz.repository.InquiryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc

@RunWith(MockitoJUnitRunner.class)
public class InquiryControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

    @Mock
    InquiryRepository repository;

    @Mock
    Inquiry inquiry1;

    @InjectMocks
    InquiryController controller;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void returnAllresult(){
        ArrayList mockList = mock(ArrayList.class);
        when(repository.findAll()).thenReturn(mockList);

        assertEquals(mockList, controller.getAllInquiries());
    }

    @Test
    public void getSingleInquiry(){
        when(repository.getOne(1L)).thenReturn(inquiry1);

        assertEquals(inquiry1, controller.getInquiryById(1L));
    }

    @Test
    public void saveInquiry(){
        controller.saveInquiry(inquiry1);

        verify(repository).save(inquiry1);
    }

    @Test
    public void deleteInquiry(){
        Long id = 1L;

        controller.deleteInquiry(id);

        verify(repository).deleteById(id);
    }
}