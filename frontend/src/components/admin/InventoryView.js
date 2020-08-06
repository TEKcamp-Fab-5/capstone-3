import React from "react";
import Paper from "@material-ui/core/Paper";

export default function InventoryView(props) {
    const { products, setProducts } = props;

    const displayListOfProductName = products.map(product => {
        return (
            <div>
                <tr>
                    <td>{product.name}</td>
                </tr>
            </div>
        );
    });

    const displayListOfProductQuantity = products.map(product => {
        return (
            <div>
                <tr>
                    <td>{product.quantityInInventory}</td>
                </tr>
            </div>
        );
    });
    return (
        <div style={{ marginTop: "5rem" }}>
            <Paper style={{ padding: "2rem" }}>
                <table>
                    <tr>
                        <th>Product Name</th>
                        <th>Product Quantity</th>
                    </tr>
                    <td>{displayListOfProductName}</td>
                    <td>{displayListOfProductQuantity}</td>
                </table>
            </Paper>
        </div>
    );
}
