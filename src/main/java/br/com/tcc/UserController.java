package br.com.tcc;

import org.brunocvcunha.instagram4j.Instagram4j;

public class UserController {

    static Instagram4j instagram = null;

    public Instagram4j getInstagram() {
        return instagram;
    }

    public Instagram4j setInstagram(Instagram4j instagram) {
        this.instagram = instagram;
        return instagram;
    }

}
