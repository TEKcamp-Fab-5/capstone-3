import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import { makeStyles } from "@material-ui/core/styles";
import Stepper from "@material-ui/core/Stepper";
import Step from "@material-ui/core/Step";
import StepLabel from "@material-ui/core/StepLabel";
import Button from "@material-ui/core/Button";
import Paper from "@material-ui/core/Paper";
import Summary from "./checkoutPages/Summary";
import ShippingAndPayment from "./checkoutPages/ShippingAndPayment";
import Confirmation from "./checkoutPages/Confirmation";
import Stripe from "../components/checkoutPages/Stripe";

const useStyles = makeStyles(theme => ({
    root: {
        width: "100%",
        paddingBottom: "2rem"
    },
    backButton: {
        marginRight: theme.spacing(1)
    },
    instructions: {
        marginTop: theme.spacing(1),
        marginBottom: theme.spacing(1)
    },
    container: {
        margin: "1rem"
    },
    paper: {
        width: "60vw",
        margin: "auto",
        padding: theme.spacing(2)
    }
}));

function getSteps() {
    return ["Summary", "Shipping/Payment", "Confirmation"];
}

function getStepContent(
    stepIndex,
    products,
    shoppingCart,
    consumerName,
    consumerEmail,
    consumerAddress,
    consumerContactNumber
) {
    // checkout: built in case from material-ui, depending on the page a specific component is displayed
    switch (stepIndex) {
        case 0:
            return <Summary products={products} shoppingCart={shoppingCart} />;
        case 1:
            return (
                <ShippingAndPayment
                    consumerName={consumerName}
                    consumerEmail={consumerEmail}
                    consumerAddress={consumerAddress}
                    consumerContactNumber={consumerContactNumber}
                />
            );
        case 2:
            return (
                <Confirmation
                    consumerName={consumerName}
                    consumerEmail={consumerEmail}
                    consumerAddress={consumerAddress}
                    consumerContactNumber={consumerContactNumber}
                />
            );
        default:
            return "Unknown stepIndex";
    }
}

export default function Checkout(props) {
    const {
        handleInventory,
        shoppingCart,
        products,
        consumerName,
        consumerEmail,
        consumerAddress,
        consumerContactNumber,
        setShoppingCart
    } = props;

    const classes = useStyles();
    const [activeStep, setActiveStep] = useState(0);
    const [paymentSubmitted, setPaymentSubmitted] = useState(false);
    const [errorInCart, setErrorInCart] = useState(false);
    const steps = getSteps();
    let history = useHistory();

    // checkoutPage: there's a check in inventory before a customer can make a purchase, if that product
    // is unavailable there is an alert that let's the customer know that the product is sold out, otherwise
    // the customer will proceed with the checkout process
    const handleNext = () => {
        if (activeStep === 0) {
            let hasSoldOutItems = handleInventory();
            setErrorInCart(hasSoldOutItems);
            if (!hasSoldOutItems) {
                setActiveStep(prevActiveStep => prevActiveStep + 1);
            }
        }

        if (activeStep === steps.length - 1) {
            history.push("/");
        }
    };

    const handleBack = () => {
        setActiveStep(prevActiveStep => prevActiveStep - 1);
    };

    return (
        <div className={classes.root}>
            <Stepper activeStep={activeStep} alternativeLabel>
                {steps.map(label => (
                    <Step key={label}>
                        <StepLabel>{label}</StepLabel>
                    </Step>
                ))}
            </Stepper>
            <div>
                {activeStep === steps.length ? (
                    <div>
                        <div className={classes.container}>
                            <Paper className={classes.paper} elevation={3}>
                                All steps completed
                            </Paper>
                        </div>
                    </div>
                ) : (
                    <div>
                        <div className={classes.container}>
                            <Paper className={classes.paper} elevation={3}>
                                {getStepContent(
                                    activeStep,
                                    products,
                                    shoppingCart,
                                    consumerName,
                                    consumerEmail,
                                    consumerAddress,
                                    consumerContactNumber
                                )}
                            </Paper>
                        </div>
                        <div>
                            <Button
                                disabled={activeStep === 0}
                                onClick={handleBack}
                                className={classes.backButton}
                            >
                                Back
                            </Button>
                            {activeStep === steps.length - 2 &&
                            !paymentSubmitted ? (
                                <Stripe
                                    setActiveStep={setActiveStep}
                                    activeStep={activeStep}
                                    setPaymentSubmitted={setPaymentSubmitted}
                                    setShoppingCart={setShoppingCart}
                                    shoppingCart={shoppingCart}
                                />
                            ) : (
                                <Button
                                    variant="contained"
                                    color="primary"
                                    onClick={handleNext}
                                    disabled={errorInCart}
                                >
                                    {activeStep === steps.length - 1
                                        ? "Done"
                                        : "Next"}
                                </Button>
                            )}
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
}
