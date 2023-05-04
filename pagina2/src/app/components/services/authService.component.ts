import { Injectable } from "@angular/core";
import { UserDTO } from "../modelo/userDTO.model";

export const AUTH_TOKEN_KEY = 'auth-token';
export const AUTH_USER_DATA = 'user-data';


@Injectable({
    providedIn: 'root'
})
export class AuthService {

    public authToken: string | null = null;
    public userData: UserDTO | null = null;

    constructor(){
        this.checkStorage();
    }

    checkStorage(){
        const authToken = sessionStorage.getItem(AUTH_TOKEN_KEY);
        const userData = sessionStorage.getItem(AUTH_USER_DATA);
        this.authToken = authToken;
        if(userData){
            this.userData = JSON.parse(userData) as any;
        }else{
            this.userData = null;
        }
    }
    login(authData: UserDTO){
        sessionStorage.setItem(AUTH_TOKEN_KEY, authData.contra + 'RANDOM_STRING');
        sessionStorage.setItem(AUTH_USER_DATA, JSON.stringify(authData));
        this.checkStorage();
    }

    public isLoggedIn(){
        return this.authToken != null;
    }

    public logout(){
        if (!this.isLoggedIn()) return;
        sessionStorage.clear();
        this.checkStorage();
    }
}