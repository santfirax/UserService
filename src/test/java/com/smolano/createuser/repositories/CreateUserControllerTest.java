package com.smolano.createuser.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smolano.createuser.entities.User;
import com.smolano.createuser.model.UserDTO;
import com.smolano.createuser.models.TypeId;
import com.smolano.createuser.resource.ICreateUserService;
import com.smolano.createuser.service.IRegisterUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ICreateUserService.class)
public class CreateUserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IRegisterUser registerUser;
    @MockBean
    private CreateUserRepository createUserRepository;
    @Autowired
    private ObjectMapper objectMapper;
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void shouldSaveUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setIdentification("1017233846");
        userDTO.setFirstName("Jose");
        userDTO.setLastName("Molano");
        userDTO.setEmail("123@hotmail.com");
        userDTO.setPhone("3022653192");
        userDTO.setTypeId(TypeId.CC);
        this.mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void shouldGetAllUsers() throws Exception {
        User userCC = new User();
        userCC.setIdentification("1017233846");
        userCC.setFirstName("Jose");
        userCC.setLastName("Molano");
        userCC.setEmail("123@hotmail.com");
        userCC.setPhone("3022653192");
        userCC.setTypeId(TypeId.CC);
        User userAS = new User();
        userAS.setIdentification("1017233846");
        userAS.setFirstName("Jose");
        userAS.setLastName("Molano");
        userAS.setEmail("123@hotmail.com");
        userAS.setPhone("3022653192");
        userAS.setTypeId(TypeId.AS);
        List<User> userList = Arrays.asList(userAS, userCC);
        when(registerUser.getAllUsers()).thenReturn(userList);
        this.mockMvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
        verify(registerUser, times(1)).getAllUsers();
    }
}
