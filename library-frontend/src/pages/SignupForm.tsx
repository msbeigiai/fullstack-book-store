import { Button, Container } from "@chakra-ui/react";
import { Form, Formik } from "formik";
import * as Yup from "yup";
import FormTextInput from "../components/FormTextInput";

interface SignupFormValues {
  firstName: string;
  lastName: string;
  email: string;
}

const SignupForm = () => {
  const initialValues: SignupFormValues = {
    firstName: "",
    lastName: "",
    email: "",
  };
  return (
    <Container maxW="md">
      <Formik
        initialValues={initialValues}
        validateOnMount
        validationSchema={Yup.object({
          firstName: Yup.string()
            .max(15, "Must be 15 characters or less")
            .required("Required"),
          lastName: Yup.string()
            .max(20, "Must be 20 characters or less")
            .required("Required"),
          email: Yup.string()
            .email("Invalid email address")
            .required("Required"),
        })}
        onSubmit={(values, { setSubmitting }) => {
          setTimeout(() => {
            alert(JSON.stringify(values, null, 2));
            setSubmitting(false);
          }, 400);
        }}
      >
        <Form>
          <FormTextInput
            label="First Name"
            name="firstName"
            type="text"
            placeholder="Jane"
            id=""
          />
          <FormTextInput
            label="Last Name"
            name="lastName"
            type="text"
            placeholder="Doe"
            id=""
          />
          <FormTextInput
            label="Email Address"
            name="email"
            type="email"
            placeholder="jane@formik.com"
            id=""
          />
          <Button type="submit" marginTop={4}>
            Submit
          </Button>
        </Form>
      </Formik>
    </Container>
  );
};

export default SignupForm;
