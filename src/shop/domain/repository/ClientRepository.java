package shop.domain.repository;

import shop.domain.entity.Client;

public class ClientRepository {
    private Client[] clients;

    public boolean existsClientById (int id) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Client getClientById (int id) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getId() == id) {
                return clients[i];
            }
        }
        return null;
    }

    public Client getClientByCNP (long CNP) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getCNP() == CNP) {
                return clients[i];
            }
        }
        return null;
    }

    public Client getClientByEmail (String email) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getEmail() == email) {
                return clients[i];
            }
        }
        return null;
    }
}
