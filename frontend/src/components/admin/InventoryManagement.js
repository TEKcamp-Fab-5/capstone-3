import React, { useState, useEffect } from "react";
import Button from "@material-ui/core/Button";
import Paper from "@material-ui/core/Paper";
import FormGroup from "@material-ui/core/FormGroup";
import TextField from "@material-ui/core/TextField";
import "../../styles/InventoryManagement.css";

// this will be an authenticated component
export default function InventoryManagement(props) {
    const { products, setProducts } = props;

    const [newProduct, setNewProduct] = useState({});

    useEffect(() => {
        console.log(products);
    }, [products]);

    const formOnChange = e => {
        setNewProduct({ ...newProduct, [e.target.name]: e.target.value });
    };

    const handleAddNewProduct = e => {
        e.preventDefault();
        newProduct.price = parseFloat(newProduct.price);
        newProduct.name = newProduct.name.replace(/ /g, "-").toLowerCase();
        setProducts([...products, newProduct]);
    };

    return (
        <div className="container">
            <div>
                <h2>Inventory Management</h2>
            </div>
            <div className="formContainer">
                <FormGroup className="formGroup">
                    <Paper className="inventoryPaper" elevation={3}>
                        <TextField
                            label="Product Name"
                            name="name"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            label="Serial Number"
                            name="serialNumber"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            label="Price"
                            name="price"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            label="Product Manufacturer"
                            name="manufacturer"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            label="Category"
                            name="category"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            label="Quantity"
                            name="quantity"
                            onChange={formOnChange}
                        />
                        <br />
                        <Button
                            variant="contained"
                            color="primary"
                            onClick={handleAddNewProduct}
                            style={{ marginTop: "2rem" }}
                        >
                            Add a new product
                        </Button>
                    </Paper>
                </FormGroup>
            </div>
        </div>
    );
}
