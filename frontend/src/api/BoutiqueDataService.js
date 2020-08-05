import axios from "axios";

class BoutiqueDataService {
    retrieveAllProducts() {
        return axios.get("http://localhost:8080/products");
    }

    retrieveProduct(product) {
        return axios.get(`http://localhost:8080/products/${product.name}`);
    }

    updateProduct(product) {
        return axios.get(
            `http://localhost:8080/products/${product.serialNumber}`
        );
    }

    addNewProduct() {
        return axios.post("http://localhost:8080/products");
    }

    deleteProduct(product) {
        return axios.delete(
            `http://localhost:8080/products/${product.serialNumber}`
        );
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
