import { Button, Container } from "@chakra-ui/react";
import { Form, Formik } from "formik";
import * as Yup from "yup";
import FormTextInput from "../components/FormTextInput";

interface LoginFormVales {
  email: string;
  password: string;
}

const LoginForm = () => {
  const intialValues: LoginFormVales = {
    email: "",
    password: "",
  };
  return (
    <Container maxW="md">
      <Formik
        initialValues={intialValues}
        validationSchema={Yup.object({
          email: Yup.string()
            .email("Invalid email address")
            .required("Required"),
          password: Yup.string()
            .required("No password provided.")
            .min(5, "Password is too short - should be 8 chars minimum."),
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
            label="Email Address"
            name="email"
            type="email"
            placeholder="jane@formik.com"
            id=""
          />
          <FormTextInput
            label="Password"
            name="password"
            type="password"
            placeholder="******"
            id=""
          />
          <Button type="submit" marginTop={4}>
            Login
          </Button>
        </Form>
      </Formik>
    </Container>
  );
};

export default LoginForm;
