package com.margo.tt.tt.account;

import com.margo.tt.tt.statement.Statement;
import com.margo.tt.tt.user.UnknownUserException;
import com.margo.tt.tt.user.User;
import com.margo.tt.tt.user.UsersManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {
    
    @GetMapping(value="/account/history")
    public ArrayList<Statement> getHistoryHandler(@RequestHeader("userId") Integer userId) {
        try  {
            UsersManager usersManager = UsersManager.getInstance();
            User user = usersManager.findUser(userId);
            return user.getAccount().getHistory();
        } catch (UnknownUserException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", e);
        }
    }
    
    @PutMapping(value="/account/deposit")
    public Statement depositHandler(@RequestHeader("userId") Integer userId, @RequestBody AccountRequestModel accountRequest) {
        try  {
            UsersManager usersManager = UsersManager.getInstance();
            User user = usersManager.findUser(userId);
            Statement statement = user.getAccount().deposit(accountRequest.amount);
            return statement;
        } catch (UnknownUserException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", e);
        }
    }

    @PutMapping(value="/account/withdrawal")
    public Statement withdrawal(@RequestHeader("userId") Integer userId, @RequestBody AccountRequestModel accountRequest) {
        try  {
            UsersManager usersManager = UsersManager.getInstance();
            User user = usersManager.findUser(userId);
            Statement statement = user.getAccount().withdrawal(accountRequest.amount);
            return statement;
        } catch (UnknownUserException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", e);
        } catch (AccountNotEnoughProvisioned e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Impossible action: account not enough provisioned", e);
        }
    }
    
}
