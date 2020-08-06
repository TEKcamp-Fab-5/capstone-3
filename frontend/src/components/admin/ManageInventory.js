import React, { useState, useEffect } from "react";
import Button from "@material-ui/core/Button";
import Paper from "@material-ui/core/Paper";
import FormGroup from "@material-ui/core/FormGroup";
import TextField from "@material-ui/core/TextField";
import "../../styles/ManageInventory.css";

import BoutiqueDataService from "../../api/BoutiqueDataService";

// this will be an authenticated component
export default function ManageInventory(props) {
    const { products, setProducts } = props;

    const [newProduct, setNewProduct] = useState({});

    useEffect(() => {
        console.log(products);
    }, [products]);

    const formOnChange = e => {
        setNewProduct({ ...newProduct, [e.target.name]: e.target.value });
    };

    const handleExistingProduct = newProduct => {
        for (let product of products) {
            if (
                product.productSerial &&
                newProduct.productSerial &&
                newProduct.productSerial === product.productSerial
            ) {
                return true;
            }

            if (
                product.name &&
                newProduct.name &&
                newProduct.name === product.name
            ) {
                return true;
            }
        }
        return false;
    };

    const handleAddNewProduct = e => {
        e.preventDefault();
        newProduct.productSerial = parseFloat(newProduct.productSerial);
        newProduct.price = parseFloat(newProduct.price);
        newProduct.quantityInInventory = parseFloat(
            newProduct.quantityInInventory
        );
        newProduct.sku = parseFloat(newProduct.sku);
        newProduct.name = newProduct.name.replace(/ /g, "-").toLowerCase();
        newProduct.image = "default-image";
        setProducts([...products, newProduct]);

        console.log(newProduct);

        const productExists = handleExistingProduct(newProduct);
        console.log(handleExistingProduct(newProduct));
        if (productExists) {
            // if (newProduct.quantityInInventory) {
            //     if (newProduct.quantityInInventory == 0) {
            //         newProduct.quantityInInventory = 0;
            //     } else {
            //         newProduct.quantityInInventory += e.target.value;
            //     }
            // }
            BoutiqueDataService.updateProduct(newProduct)
                .then(res => {
                    console.log(res, "updated product");
                })
                .catch(error => {
                    console.log(error);
                });
        } else {
            BoutiqueDataService.addNewProduct(newProduct)
                .then(res => {
                    console.log(res, "added product");
                })
                .catch(error => {
                    console.log(error);
                });
        }
    };

    return (
        <div className="container">
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
                            label="Description"
                            name="description"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            label="Manufacturer"
                            name="manufacturer"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            label="Serial Number"
                            name="productSerial"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            label="SkuNumber"
                            name="sku"
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
                            label="Category"
                            name="category"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            label="Quantity"
                            name="quantityInInventory"
                            onChange={formOnChange}
                            type="number"
                        />
                        <br />
                        <br />
                        <Button
                            variant="contained"
                            color="primary"
                            component="label"
                        >
                            Upload File
                            <input
                                type="file"
                                style={{ display: "none" }}
                                name="image"
                            />
                        </Button>
                        <br />
                        <Button
                            variant="contained"
                            color="primary"
                            onClick={handleAddNewProduct}
                            style={{ marginTop: "2rem" }}
                        >
                            Add Product
                        </Button>
                    </Paper>
                </FormGroup>
            </div>
        </div>
    );
}
