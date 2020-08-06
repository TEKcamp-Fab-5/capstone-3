import axios from "axios";

class BoutiqueDataService {
    retrieveAllProducts() {
        return axios.get("http://localhost:8080/products");
    }

    updateProduct(payload) {
        return axios.put(
            "http://localhost:8080/products/updateProduct",
            payload,
            {
                headers: {
                    "Content-Type": "application/json"
                }
            }
        );
    }

    addNewProduct(payload) {
        return axios.post("http://localhost:8080/products/", payload, {
            headers: {
                "Content-Type": "application/json"
            }
        });
    }

    deleteProduct() {
        return axios.delete("http://localhost:8080/products/deleteProduct");
    }

    addCustomer() {
        return axios.post("http://localhost:8080/customers/");
    }

    retrieveCustomer(customer) {
        return axios.get(`http://localhost:8080/customer/${customer.id}`);
    }

    updateCustomer(customer) {
        return axios.put(`http://localhost:8080/customer/${customer.id}`);
    }

    deleteCustomer(customer) {
        return axios.delete(`http://localhost:8080/customer/${customer.id}`);
    }
}

export default new BoutiqueDataService();
