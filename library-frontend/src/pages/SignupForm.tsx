import { Form, Formik } from "formik";
import * as Yup from "yup";
import FormTextInput from "../components/FormTextInput";
import { Button } from "@chakra-ui/react";

const SignupForm = () => {
  return (
    <>
      <Formik
        initialValues={{ firstName: "", lastName: "", email: "" }}
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
            id={""}
            children={undefined}
          />
          <FormTextInput
            label="Last Name"
            name="lastName"
            type="text"
            placeholder="Doe"
            id={""}
            children={undefined}
          />

          <FormTextInput
            label="Email Address"
            name="email"
            type="email"
            placeholder="jane@formik.com"
            id={""}
            children={undefined}
          />
          <Button type="submit">Submit</Button>
        </Form>
      </Formik>
    </>
  );
};

export default SignupForm;
