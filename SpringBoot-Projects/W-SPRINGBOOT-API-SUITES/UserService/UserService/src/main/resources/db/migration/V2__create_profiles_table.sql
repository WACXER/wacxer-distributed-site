-- V2__create_profiles_table.sql
-- Add profiles table for user profile management, linked to users (one-to-one)

-- Create profiles table
CREATE TABLE profiles (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID UNIQUE NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    name TEXT,
    business_type TEXT CHECK (business_type IN ('retail', 'wholesale', 'service', 'manufacturing', 'other')),  -- Example enum-like constraint; adjust as needed
    profile_picture_url TEXT,
    cover_photo_url TEXT,
    is_premium BOOLEAN DEFAULT FALSE,
    is_verified BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

-- Indexes for performance
CREATE INDEX idx_profiles_user_id ON profiles(user_id);
CREATE INDEX idx_profiles_is_verified ON profiles(is_verified);
CREATE INDEX idx_profiles_is_premium ON profiles(is_premium);
CREATE INDEX idx_profiles_business_type ON profiles(business_type);

-- Trigger for updated_at
CREATE TRIGGER update_profiles_updated_at BEFORE UPDATE ON profiles
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Row Level Security (optional, matching users table)
ALTER TABLE profiles ENABLE ROW LEVEL SECURITY;
CREATE POLICY "Users can view their own profile" ON profiles
    FOR SELECT USING (user_id::text = current_setting('app.user_id', true));
CREATE POLICY "Users can update their own profile" ON profiles
    FOR UPDATE USING (user_id::text = current_setting('app.user_id', true));
CREATE POLICY "Admins can view all profiles" ON profiles
    FOR ALL USING (current_setting('app.user_role', true) = 'ADMIN');