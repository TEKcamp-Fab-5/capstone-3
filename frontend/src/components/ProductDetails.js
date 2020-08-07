import React from "react";
import Product from "./Product";
import Button from "@material-ui/core/Button";
import "../styles/ProductDetails.css";

export default function ProductDetails(props) {
    const { products, match, handleAddingItemsToCart } = props;

    const { name } = match.params;

    const productDescription = (description) =>{
        if ( description !== "" || description!=null ){
            return description;
        } else {
            return null;
        }
    }

    // productDetails: dynamically displays the corresponding products with the
    // products details: name, serial number, category and a button to add that
    // specific product to the cart
    const displayProduct = products.map(product => {
        if (name == product.name)
            return (
                <div className="productDetails">
                    <Product
                        key={product.id}
                        product={product}
                        products={products}
                    />
                    <div className="info">
                        <p>SKU Number: {product.sku}</p>
                        <p>
                            {productDescription(product.description)}

                        </p>
                        {/*<p>{product.description}</p>*/}
                        <p>
                            Quantity in Inventory: {product.quantityInInventory}
                        </p>
                    </div>

                    <Button
                        variant="contained"
                        color="primary"
                        onClick={() => {
                            handleAddingItemsToCart(product);
                        }}
                    >
                        Add to Cart
                    </Button>
                </div>
            );
    });

    return (
        <div>
            <p>{displayProduct}</p>
        </div>
    );
}
