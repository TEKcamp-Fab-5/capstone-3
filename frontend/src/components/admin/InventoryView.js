import React from "react";
import Paper from "@material-ui/core/Paper";

export default function InventoryView(props) {
    const { products, setProducts } = props;

    const displayListOfProductSerial = products.map(product => {
        return (
            <div align={"center"}>
                <tr>
                    <td>{product.sku}</td>
                </tr>
            </div>
        )
    })

    const displayListOfProductName = products.map(product => {
        return (
            <div>
                <tr>
                    <td>{product.name.replace(/-/g, " ")}</td>
                </tr>
            </div>
        );
    });

    const displayListOfProductPrice = products.map(product => {
        return (
            <div  align={"center"}>
                <tr>
                    <td>${product.price}</td>
                </tr>
            </div>
        );
    });

    const displayListOfProductCategory = products.map(product => {
        return (
            <div align={"center"}>
                <tr>
                    <td>{product.category.charAt(0).toUpperCase()}</td>
                </tr>
            </div>
        );
    });

    const displayListOfProductManufacturer= products.map(product => {
        return (
            <div  align={"center"}>
                <tr>
                    <td>{product.manufacturer}</td>
                </tr>
            </div>
        );
    });

    const displayListOfProductDescription = products.map(product => {
        return (
            <div  align={"center"}>
                <tr>
                    <td>{product.description.slice(0,20)}...</td>
                </tr>
            </div>
        );
    });

    const displayListOfProductQuantity = products.map(product => {
        return (
            <div align={"center"}>
                <tr>
                    <td >{product.quantityInInventory}</td>
                </tr>
            </div>
        );
    });
    return (
        <div style={{ marginTop: "5rem" }}>
            <Paper style={{ padding: "2rem", width:"50rem" }}>
                <table style={{width:"45rem"}}>
                    <tr>
                        <th>SKU</th>
                        <th>Name</th>
                        <th>MSRP</th>
                        <th>CAT</th>
                        <th>MFR</th>
                        <th>Desc</th>
                        <th>QTY</th>
                    </tr>
                    <td>{displayListOfProductSerial}</td>
                    <td>{displayListOfProductName}</td>
                    <td>{displayListOfProductPrice}</td>
                    <td>{displayListOfProductCategory}</td>
                    <td>{displayListOfProductManufacturer}</td>
                    <td>{displayListOfProductDescription}</td>
                    <td>{displayListOfProductQuantity}</td>
                </table>
            </Paper>
        </div>
    );
}
