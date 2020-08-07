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
                product.sku &&
                newProduct.sku &&
                newProduct.sku === product.sku
            ) {
                return product;
            }
        }
        return null;
    };

    const handleAddNewProduct = e => {
        e.preventDefault();
        newProduct.sku=parseFloat(newProduct.sku);

        const productExists = handleExistingProduct(newProduct);
        if (productExists!=null) {

            if (newProduct.name!==(""||null)) {
                productExists.name = newProduct.name;
            }

            if (newProduct.description!==(""||null)) {
                productExists.description = newProduct.description;
            }
            
            if (newProduct.manufacturer!==(""||null)) {
                productExists.manufacturer = newProduct.manufacturer;
            }

            if (parseFloat(newProduct.price)!==(0||null)) {
                productExists.price=parseFloat(newProduct.price)
            }

            if (parseInt(newProduct.quantityInInventory)!==(0||null)) {
                productExists.quantityInInventory = parseInt(newProduct.quantityInInventory);
            }

            BoutiqueDataService.updateProduct(productExists)
                .then(res => {
                    console.log(res, "updated product");
                    refreshPage();
                })
                .catch(error => {
                    console.log(error);
                });

        } else {
            newProduct.name = newProduct.name.replace(/ /g, "-").toLowerCase();
            // newProduct.productSerial = parseFloat(newProduct.productSerial);
            newProduct.price = parseFloat(newProduct.price);
            newProduct.quantityInInventory = parseFloat(
                newProduct.quantityInInventory
            );
            newProduct.sku = parseFloat(newProduct.sku);

            newProduct.image = "default-image";

            console.log(newProduct);

            if(
                // parseFloat(newProduct.productSerial)!==(null||0) &&
                newProduct.name !== "" && newProduct.description !== "" && newProduct.manufacturer !== "" && parseInt(newProduct.sku) !== 0 && parseInt(newProduct.sku)<100000
                && parseFloat(newProduct.price) !== 0 && newProduct.category !== "" && parseInt(newProduct.quantityInInventory) !== 0
            ) {
                BoutiqueDataService.addNewProduct(newProduct)
                    .then(res => {
                        console.log(res, "added product");
                        setProducts([...products, newProduct]);
                    })
                    .catch(error => {
                        console.log(error);
                    });
            } else{
                console.log("Error: Fields not complete")
            }
        }
    };
    function refreshPage() {
        window.location.reload(false);
    }



    return (
        <div className="container">
            <div className="formContainer">
                <FormGroup className="formGroup">
                    <Paper className="inventoryPaper" elevation={3}>
                        <TextField
                            fullWidth={true}
                            label="Product Name"
                            name="name"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            fullWidth={true}
                            label="Description"
                            name="description"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            fullWidth={true}
                            label="Manufacturer"
                            name="manufacturer"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            fullWidth={true}
                            label="Sku Number"
                            name="sku"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            fullWidth={true}
                            label="Price"
                            name="price"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            fullWidth={true}
                            label="Category"
                            name="category"
                            onChange={formOnChange}
                        />
                        <br />
                        <TextField
                            fullWidth={true}
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
                            Add/Update Product
                        </Button>
                    </Paper>
                </FormGroup>
            </div>
        </div>
    );
}
