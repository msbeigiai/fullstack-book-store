import {
  Alert,
  AlertDescription,
  AlertIcon,
  AlertTitle,
  Button,
  Container,
} from "@chakra-ui/react";
import { Form, Formik } from "formik";
import * as Yup from "yup";
import FormTextInput from "../components/FormTextInput";
import useUsers from "../hooks/useUsers";

interface SignupFormValues {
  name: string;
  email: string;
  password: string;
  imageUrl: string;
}

const SignupForm = () => {
  const setUserRegister = useUsers();
  const initialValues: SignupFormValues = {
    name: "",
    email: "",
    password: "",
    imageUrl: "",
  };
  return (
    <Container maxW="md">
      {setUserRegister.error && (
        <Alert status="error">
          <AlertIcon />
          <AlertTitle>Error</AlertTitle>
          <AlertDescription>{setUserRegister.error.message}</AlertDescription>
        </Alert>
      )}
      <Formik
        initialValues={initialValues}
        validateOnMount
        validationSchema={Yup.object({
          name: Yup.string()
            .max(10, "Must be 15 characters or less")
            .required("Required"),
          email: Yup.string()
            .email("Invalid email address")
            .required("Required"),
          password: Yup.string()
            .max(20, "Must be 10 characters or less")
            .required("Required"),
        })}
        onSubmit={(data, { setSubmitting }) => {
          setTimeout(() => {
            // alert(JSON.stringify(data, null, 2));
            setUserRegister.mutate(data);
            setSubmitting(false);
          }, 400);
        }}
      >
        <Form>
          <FormTextInput
            label="First Name"
            name="name"
            type="text"
            placeholder="Jane"
            id=""
          />
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
            placeholder="********"
            id=""
          />
          <Button
            type="submit"
            marginTop={4}
            disabled={setUserRegister.isLoading}
          >
            {setUserRegister.isLoading ? "Submitting..." : "Submit"}
          </Button>
        </Form>
      </Formik>
    </Container>
  );
};

export default SignupForm;
