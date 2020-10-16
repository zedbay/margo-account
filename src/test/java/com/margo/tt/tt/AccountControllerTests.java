package com.margo.tt.tt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.margo.tt.tt.account.AccountRequestModel;
import com.margo.tt.tt.user.User;
import com.margo.tt.tt.user.UsersManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHistory() throws Exception {
        this.mockMvc.perform(get("/account/history").header("userId", 0))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturn404() throws Exception {
        this.mockMvc.perform(get("/account/history").header("userId", "10"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn400() throws Exception {
        this.mockMvc.perform(put("/account/deposit").header("userId", 0))
                .andExpect(status().isBadRequest());
    }

    // @Test
    public void testWithdrawal() throws Exception {
        UsersManager usersManager = UsersManager.getInstance();
        User user = new User();
        usersManager.addUser(user);
        AccountRequestModel request = new AccountRequestModel((float) 0);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestInString = objectMapper.writeValueAsString(request);

        this.mockMvc.perform(
                put("/account/withdrawal")
                        .header("userId", user.getId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(requestInString))
                .andExpect(status().isOk());
    }

    // @Test
    public void testDepositRoute() throws Exception {
        UsersManager usersManager = UsersManager.getInstance();
        User user = new User();
        usersManager.addUser(user);
        AccountRequestModel request = new AccountRequestModel((float) 122);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestInString = objectMapper.writeValueAsString(request);

       this.mockMvc.perform(
               put("/account/deposit")
                       .header("userId", user.getId())
                       .contentType(MediaType.APPLICATION_JSON_VALUE)
                       .content(requestInString))
               .andExpect(status().isOk());
    }





}
